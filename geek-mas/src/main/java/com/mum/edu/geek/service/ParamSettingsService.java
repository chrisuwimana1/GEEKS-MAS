package com.mum.edu.geek.service;

import com.mum.edu.geek.domain.Block;
import com.mum.edu.geek.domain.Entry;
import com.mum.edu.geek.repository.BlockRepository;
import com.mum.edu.geek.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParamSettingsService {
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private EntryRepository entryRepository;

    public List<Entry> findAllEntries() {
        return entryRepository.findAll();
    }

    public List<Block> findAllBlocks() {
        return blockRepository.findAll();
    }
}
