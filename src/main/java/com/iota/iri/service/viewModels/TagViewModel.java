package com.iota.iri.service.viewModels;

import com.iota.iri.model.Hash;
import com.iota.iri.model.Tag;
import com.iota.iri.service.tangle.Tangle;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * Created by paul on 3/6/17 for iri.
 */
public class TagViewModel {
    private final Tag tag;

    public TagViewModel(byte[] bytes) {
        tag = new Tag();
        tag.bytes = bytes;
    }
    public TagViewModel(Tag tag) {
        this.tag = tag;
    }

    public Hash getHash() {
        return new Hash(tag.bytes);
    }

    public Hash[] getTransactionHashes() throws ExecutionException, InterruptedException {
        Tangle.instance().load(tag).get();
        return tag.transactions;
    }
}
