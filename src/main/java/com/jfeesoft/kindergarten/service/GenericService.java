package com.jfeesoft.kindergarten.service;

import java.io.Serializable;

public interface GenericService<T, K extends Serializable>
{
  public T save(T entity);
}
