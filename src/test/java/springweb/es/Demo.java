package springweb.es;

import org.springframework.web.bind.annotation.RestController;

/**
 * es分组查询
 * 
 * @author Json
 *
 */
@RestController
public class Demo {

    // @Autowired
    // private ElasticsearchTemplate eTemplate;
    //
    // @GetMapping("/test")
    // public String test() {
    // /**
    // * 参考yx中StageController2
    // */
    // BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
    // // 共享到教育云的
    // TermQueryBuilder viewScope = new TermQueryBuilder("viewScope", 2);
    // boolQueryBuilder.must(viewScope);
    // // 审核通过的
    // TermQueryBuilder statusBuilder = new TermQueryBuilder("status", 1);
    // boolQueryBuilder.must(statusBuilder);
    //
    // ZoneId zoneId = ZoneId.systemDefault();
    // LocalDate localDate = LocalDate.of(2017, 12, 4);
    // ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
    // Date date2 = Date.from(zdt.toInstant());
    //
    // LocalDate localDate2 = LocalDate.of(2016, 1, 4);
    // ZonedDateTime zdt2 = localDate2.atStartOfDay(zoneId);
    // Date date3 = Date.from(zdt2.toInstant());
    // // 活动期间的
    // RangeQueryBuilder rangequerybuilder =
    // QueryBuilders.rangeQuery("uploadTime").lte(date2.getTime())
    // .gte(date3.getTime());
    //
    // boolQueryBuilder.must(rangequerybuilder);
    //
    // ValueCountBuilder countAll = AggregationBuilders.count("id").field("id");
    //
    // // 按typeId分组
    // TermsBuilder aggTermsBuilder2 =
    // AggregationBuilders.terms("resType").field("typeId");
    // // 按userId分组
    // TermsBuilder aggTermsBuilder =
    // AggregationBuilders.terms("userId").field("uploaderId").subAggregation(countAll)
    // // 再按typeId
    // .subAggregation(aggTermsBuilder2);
    // // 按学校分组
    // TermsBuilder aggTermsBuilder3 =
    // AggregationBuilders.terms("sch").field("uploaderSchoolId")
    // .subAggregation(aggTermsBuilder).size(0);
    //
    // SearchQuery query = new
    // NativeSearchQueryBuilder().withQuery(boolQueryBuilder).withIndices("yxy_res")
    // .withTypes("resource").addAggregation(aggTermsBuilder3).build();
    // Aggregations aggregations = eTemplate.query(query, new
    // ResultsExtractor<Aggregations>() {
    // @Override
    // public Aggregations extract(SearchResponse response) {
    // return response.getAggregations();
    // }
    // });
    //
    // Terms terms = aggregations.get("sch");
    // List<Bucket> teacherCountbuckets = terms.getBuckets();
    // for (Bucket bucket : teacherCountbuckets) {
    // System.out.println(bucket.getKeyAsString() + "：学校Id");
    // Terms terms2 = bucket.getAggregations().get("userId");
    // List<Bucket> buckets = terms2.getBuckets();
    // for (Bucket bucket2 : buckets) {
    // System.out.println(bucket2.getKeyAsString() + "====");
    // System.out.println(bucket2.getDocCount() + "----------");
    //
    // ValueCount dCount = bucket2.getAggregations().get("id");
    // System.out.println(dCount.getValue() + "=====id");
    //
    // Terms terms3 = bucket2.getAggregations().get("resType");
    // List<Bucket> bucket3 = terms3.getBuckets();
    // for (Bucket bucket4 : bucket3) {
    // System.out.println(bucket4.getKeyAsString() + "====");
    // System.out.println(bucket4.getDocCount() + "----------");
    // }
    //
    // }
    // }
    //
    // return "999999999";
    // }

}
