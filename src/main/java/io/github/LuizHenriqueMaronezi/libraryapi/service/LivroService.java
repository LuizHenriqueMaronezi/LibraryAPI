package io.github.LuizHenriqueMaronezi.libraryapi.service;

import io.github.LuizHenriqueMaronezi.libraryapi.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;
}
