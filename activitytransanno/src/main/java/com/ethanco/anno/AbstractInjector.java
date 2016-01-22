package com.ethanco.anno;

public interface AbstractInjector<T>
{
	void inject(Finder finder, T target, Object source);
}
