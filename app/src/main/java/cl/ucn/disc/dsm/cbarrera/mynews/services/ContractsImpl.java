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

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.cbarrera.mynews.model.News;

/**
 * Implementation of Contracts
 * @author Camilo Barrera A., camilo.barrera@alumnos.ucn.cl
 */
public class ContractsImpl implements Contracts {
    /**
     * Get List of news.
     *
     * @param size size of the list.
     * @return the list of news.
     */
    @Override
    public List<News> retrieveNews(Integer size) {
        final List<News> news = new ArrayList<>();
        return news;
    }

    /**
     * Save one news into the system.
     * @param news to save
     */
    @Override
    public void saveNews(News news) {
    }
}
