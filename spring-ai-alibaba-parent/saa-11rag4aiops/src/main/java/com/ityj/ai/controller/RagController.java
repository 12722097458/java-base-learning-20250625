package com.ityj.ai.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.rag.advisor.RetrievalAugmentationAdvisor;
import org.springframework.ai.rag.retrieval.search.VectorStoreDocumentRetriever;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class RagController {

    @Autowired
    @Qualifier("qwenChatClient")
    private ChatClient chatClient;

    @Resource
    private VectorStore vectorStore;


    /**
     * http://localhost:8011/rag?msg=00000
     *
     * @param msg
     * @return
     */
    @GetMapping("/rag")
    public Flux<String> rag(@RequestParam(name = "msg") String msg) {
        String systemInfo = """
                你是一个运维工程师,按照给出的编码给出对应故障解释,否则回复找不到信息。
                """;
        RetrievalAugmentationAdvisor advisor = RetrievalAugmentationAdvisor.builder()
                .documentRetriever(VectorStoreDocumentRetriever.builder().vectorStore(vectorStore).build())
                .build();

        return chatClient
                .prompt()
                .system(systemInfo)
                .user(msg)
                .advisors(advisor)
                .stream()
                .content();
    }

    @GetMapping("/embed2vector/add")
    public void add() {
        List<Document> documents = List.of(
                new Document("i study LLM"),
                new Document("i love java")
        );

        vectorStore.add(documents);
    }

    @GetMapping("/embed2vector/get")
    public List getAll(@RequestParam(name = "msg") String msg) {
        SearchRequest searchRequest = SearchRequest.builder()
                .query(msg)
                .topK(2)
                .build();

        List<Document> list = vectorStore.similaritySearch(searchRequest);

        System.out.println(list);

        return list;
    }
}


