package com.security;

import com.security.controller.AnimeController;
import com.security.controller.AuthController;
import com.security.model.*;
import com.security.repo.AnimeRepo;
import com.security.repo.TokenRepo;
import com.security.service.AnimeService;
import com.security.service.JwtService;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class SecurityApplicationTests {
	
}