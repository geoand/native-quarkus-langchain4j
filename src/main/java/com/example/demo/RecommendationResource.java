package com.example.demo;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.resteasy.reactive.RestForm;

@Blocking
@Path("")
public class RecommendationResource {

    private final RecommendationService recommendationService;
    private final Template form;
    private final Template result;

    public RecommendationResource(RecommendationService recommendationService, Template form, Template result) {
        this.recommendationService = recommendationService;
        this.form = form;
        this.result = result;
    }

    @GET
    @Path("request")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance request() {
        return form.instance();
    }

    @POST
    @Path("recommend")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance response(@RestForm String country, @RestForm String activity, @RestForm String mood) {
        return result.data("recommendation", recommendationService.recommend(country, activity, mood));
    }
}
