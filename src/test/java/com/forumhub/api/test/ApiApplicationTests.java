/*package com.forumhub.api.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetTopics() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/topics", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("topic"));  // Verifica que haya algún tópico en la respuesta
	}

	@Test
	void testCreateTopic() {
		String newTopic = "{ \"title\": \"New Topic\", \"description\": \"Description of new topic\" }";

		ResponseEntity<String> response = restTemplate.postForEntity("/api/topics", newTopic, String.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertTrue(response.getBody().contains("New Topic"));
	}

	@Test
	void testUpdateTopic() {
		String updatedTopic = "{ \"title\": \"Updated Topic\", \"description\": \"Updated description\" }";
		Long topicId = 1L; // Asegúrate de que el ID 1 exista

		restTemplate.put("/api/topics/{id}", updatedTopic, topicId);

		ResponseEntity<String> response = restTemplate.getForEntity("/api/topics/{id}", String.class, topicId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("Updated Topic"));
	}

	@Test
	void testDeleteTopic() {
		Long topicId = 1L; // Asegúrate de que el ID 1 exista

		restTemplate.delete("/api/topics/{id}", topicId);

		ResponseEntity<String> response = restTemplate.getForEntity("/api/topics/{id}", String.class, topicId);

		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testAuthenticatedAccess() {
		String token = "your_valid_token"; // Obtén el token válido del proceso de login

		ResponseEntity<String> response = restTemplate.withBasicAuth("username", "password")
				.getForEntity("/api/topics", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertTrue(response.getBody().contains("topic"));
	}

	@Test
	void testUnauthenticatedAccess() {
		ResponseEntity<String> response = restTemplate.getForEntity("/api/topics", String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
	}
} */