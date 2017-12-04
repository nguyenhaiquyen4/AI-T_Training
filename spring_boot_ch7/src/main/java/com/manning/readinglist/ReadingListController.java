package com.manning.readinglist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
@ConfigurationProperties("amazon")
public class ReadingListController {

    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonConfig;
    private CounterService counterService;
    private GaugeService gaugeService;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,
                                 AmazonProperties amazonConfig,
                                 @Qualifier("counterService") CounterService counterService,
                                 @Qualifier("gaugeService") GaugeService gaugeService) {
        this.readingListRepository = readingListRepository;
        this.amazonConfig = amazonConfig;
        this.counterService = counterService;
        this.gaugeService = gaugeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String readersBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonConfig.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        counterService.increment("books.saved");
        gaugeService.submit("books.last.saved", System.currentTimeMillis());
        return "redirect:/";
    }

}
