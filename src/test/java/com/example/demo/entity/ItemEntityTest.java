package com.example.demo.entity;

import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
public class ItemEntityTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        String name = "name";
        String description = "description";

        User user = userRepository.findById(1L).orElse(null);
        Item item = new Item(name, description, user, user, null);

        itemRepository.save(item);
        Item returnItem = itemRepository.findById(item.getId()).orElse(null);

        Assertions.assertNull(item.getStatus());
        Assertions.assertNotNull(returnItem.getStatus());
    }
}
