package com.packt.legacy.unfavorable.construct.newexpression;

public class NewExpressionDependency {

	public void testMe() {
		PoisonIvy ivy = new PoisonIvy();
		ivy.poison();
	}
}
