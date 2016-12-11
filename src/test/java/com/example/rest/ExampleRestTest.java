package com.example.rest;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.ExampleResult;

/**
 * Notes: WebEnvironment.RANDOM_PORT enables autowiring of TestRestTemplate for testing
 * Controller mappings. If using WebEnvironment.MOCK, TestRestTemplate is not available.
 * @author kevinhooke
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleRestTest {
		@Autowired
		private TestRestTemplate restTemplate;

		@Test
		public void exampleTest() {
			ExampleResult result = this.restTemplate.getForObject("/example1", ExampleResult.class);
			assertTrue(result.getValue().equals("GET with no path param"));
		}

		@Test
		public void exampleTest2() {
			ExampleResult result = this.restTemplate.getForObject("/example1/abc", ExampleResult.class);
			assertTrue(result.getValue().equals("abc"));
		}

		@Test
		public void exampleTest_withUrlEncodedValues() throws UnsupportedEncodingException {
			String value = URLEncoder.encode("example/one-slash", "UTF-8");
			System.out.println("Encoded value: " + value);
			ExampleResult result = this.restTemplate.getForObject("/example1/" + value, ExampleResult.class);
			assertTrue(result.getValue().equals(value));
		}

	}
