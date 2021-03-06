/*
 * Copyright(c)
 *
 * Copyright 2020 Camilo Barrera Arancibia, camilo.barrera@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.cbarrera.mynews.services;

import com.kwabenaberko.newsapilib.models.Article;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.cbarrera.mynews.model.News;
import cl.ucn.disc.dsm.cbarrera.mynews.util.Validation;

/**
 * The newsAPI implementation via Retrofit.
 *
 * @author Camilo Barrera Arancibia, camilo.barrera@alumnos.ucn.cl
 */
public final class ContractsImplNewsApi implements Contracts{

    /**
     * The logger.
     */
    private static final Logger log = LoggerFactory.getLogger(ContractsImplNewsApi.class);

    /**
     * The connection to NewsApi.
     */
    private final NewsApiService newsApiService;

    /**
     * The contructor
     *
     * @param theApiKey to use.
     */
    public ContractsImplNewsApi(final String theApiKey) {

        Validation.minSize(theApiKey,10,"Apikey!!");

        this.newsApiService = new NewsApiService(theApiKey);
    }

    private static News toNews(final Article article) {
        Validation.notNull(article, "Article null!!??");

        //Warning message?
        boolean needFix = false;

        //fix the author null
        if (article.getAuthor() == null) {
            article.setAuthor("No author");
            needFix = true;
        }

        //fix more restrictions
        if (article.getDescription() == null || article.getDescription().length() == 0) {
            article.setDescription("No description*");
            needFix = true;
        }



        //.. yes, warning message.
        if (needFix) {
        // Debug of Article
            log.warn("Article with invalid restrictions: {}.", ToStringBuilder.reflectionToString( article, ToStringStyle.MULTI_LINE_STYLE));
        }

        // The date
        ZonedDateTime publishedAt = ZonedDateTime
                .parse(article.getPublishedAt())
                .withZoneSameInstant(ZoneId.of("-3"));

        // The News
        return new News(
                article.getTitle(), article.getSource().getName(), article.getAuthor(), article.getUrl(), article.getUrlToImage(), article.getDescription(),
                article.getDescription(), // FIXME: Where is the content?
                publishedAt
        );
    }


    @Override
    public List<News> retrieveNews(Integer size) {
        try {
            List<Article> articles = newsApiService.getTopHeadLines("technology",127);

            List<News> news = new ArrayList<>();
            for(Article article : articles){
                //log.debug("Article: {}",toStringBuilder.reflectionToString(article,toStringStule.MULTI_LINE_STYLE));
                news.add(toNews(article));
            }
            return news;
        } catch (IOException e) {
            log.error("Error",e);
            return null;
        }
    }

    @Override
    public void saveNews(News news) {
        throw new NotImplementedException("Can't save in NewsAPI");
    }
}
