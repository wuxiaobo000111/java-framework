package com.bobo.springcloud.learn.hystrixeurekacollasper.service;


import java.util.concurrent.Future;

public interface ICollapsingService {
	public Future<Animal> collapsing(Integer id);
	public Animal collapsingSyn(Integer id);
	public Future<Animal> collapsingGlobal(Integer id);
	
}
