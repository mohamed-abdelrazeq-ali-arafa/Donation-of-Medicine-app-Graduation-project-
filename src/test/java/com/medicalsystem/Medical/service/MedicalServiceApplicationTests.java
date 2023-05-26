package com.medicalsystem.Medical.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class MedicalServiceApplicationTests {
	Clac c =new Clac();
	@Test
	void iTShouldAdd() {

		int x=60;int y=90;
		int res=c.add(x,y);
		assertThat(res).isEqualTo(150);
	}
	class Clac{
		public int add(int x,int y){
			return x+y;
		}
	}

}
