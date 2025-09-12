package com.ityj.springboot.es.test;

import com.alibaba.fastjson.JSON;
import com.ityj.springboot.es.domain.Hotel;
import com.ityj.springboot.es.domain.HotelDoc;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@SpringBootTest
public class ESDocTest {

    @Autowired
    private RestHighLevelClient client;


    @Test
    void testAddDocument() throws IOException {
        // 批量查询酒店数据
        List<Hotel> hotels = mock();

        // 1.创建Request
        BulkRequest request = new BulkRequest();
        // 2.准备参数，添加多个新增的Request
        for (Hotel hotel : hotels) {
            // 2.1.转换为文档类型HotelDoc
            HotelDoc hotelDoc = new HotelDoc(hotel);
            // 2.2.创建新增文档的Request对象
            request.add(new IndexRequest("hotel")
                    .id(hotelDoc.getId().toString())
                    .source(JSON.toJSON(hotelDoc), XContentType.JSON));//实体类转JSON，指定JSON格式
        }
        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    private List<Hotel> mock() {
        List<Hotel> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hotel hotel = new Hotel();

            hotel.setId((long) i);
            hotel.setName("name" + i);
            hotel.setAddress("address" + i);
            hotel.setPrice((int) (Math.random() * 100  + i));
            hotel.setScore( i);
            hotel.setBrand("brand" + i);
            hotel.setCity("city" + i);
            hotel.setStarName("starName" + i);
            hotel.setBusiness("business" + i);
            hotel.setLongitude("longitude" + i);
            hotel.setLatitude("latitude" + i);
            hotel.setName("pic" + i);
            result.add(hotel);
        }
        return result;
    }


    @Test
    void testBulkRequest() throws IOException {
        // 批量查询酒店数据
        List<Hotel> hotels = mock();

        // 1.创建Request
        BulkRequest request = new BulkRequest();
        // 2.准备参数，添加多个新增的Request
        for (Hotel hotel : hotels) {
            // 2.1.转换为文档类型HotelDoc
            HotelDoc hotelDoc = new HotelDoc(hotel);
            // 2.2.创建新增文档的Request对象
            request.add(new IndexRequest("hotel")
                    .id(hotelDoc.getId().toString())
                    .source(hotelDoc, XContentType.JSON));
        }
        // 3.发送请求
        client.bulk(request, RequestOptions.DEFAULT);
    }

    @Test
    void testGetDocumentById() throws IOException {
        // 1.准备Request
        GetRequest request = new GetRequest("hotel", "61082");
        // 2.发送请求，得到响应
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        // 3.解析响应结果
        String json = response.getSourceAsString();

        System.out.println(json);
    }


    @Test
    void testDeleteDocument() throws IOException {
        //0.查询数据库中的数据
        List<Hotel> list = mock();
        // 1.创建Request
        BulkRequest request = new BulkRequest();
        //2.批量转换实体类，顺便写入到ES中
        for (Hotel hotel : list) {
            //2.1转换实体类
            HotelDoc hotelDoc =new HotelDoc(hotel);
            //2.2写入ES
            request.add(new DeleteRequest("hotel")
                    .id(hotel.getId().toString()));
        }
        //3.发送请求
        client.bulk(request,RequestOptions.DEFAULT);
    }


    @Test
    void testUpdateDocument() throws IOException {
        //0.查询数据库中的数据
        List<Hotel> list = mock();
        // 1.创建Request
        BulkRequest request = new BulkRequest();
        //2.批量转换实体类，顺便写入到ES中
        for (Hotel hotel : list) {
            //2.1转换实体类
            HotelDoc hotelDoc =new HotelDoc(hotel);
            //2.2写入ES
            request.add(new UpdateRequest("hotel",hotel.getId().toString())
                    .doc(
                            "price", "952",
                            "starName", "四钻"
                    ));
        }
        //3.发送请求
        client.bulk(request,RequestOptions.DEFAULT);
    }



}


