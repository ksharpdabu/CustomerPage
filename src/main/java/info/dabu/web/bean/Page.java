package info.dabu.web.bean;

/**
 * Created by AlexY on 2016/7/28.
 */

import java.util.List;

/**
 * 封装所有与分页有关的信息
 */
public class Page {

    private List reacords; //分页查询的记录,关键的地方

    private int pageSize = 10; //页面显示的记录的条数

    private int pageNum; //当前页码

    private int totalPageNum; //总页数

    private int startIndex; // 每页开始记录的索引
    private int totalRecordsNum; // 总记录的条数


    private int previousPageNum; // 上一页页码
    private int nextPageNum; // 下一页页码


    private int startPage; //页码：开始
    private int endPage; //页码：结束



    private String url; //查询记录的Servlet的url

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public Page(int pageNum, int totalRecordsNum) {
        this.pageNum = pageNum;
        this.totalRecordsNum = totalRecordsNum;


//        计算总页数
        this.totalPageNum = totalRecordsNum % pageSize == 0 ? totalRecordsNum / pageSize : totalRecordsNum / pageSize + 1;

//        计算每页的开始记录的索引值
        if (pageNum > 0) {
            this.startIndex = (pageNum - 1) * pageSize;

        } else {
            this.startIndex = 0;
        }


//        页码计算
        if (totalPageNum <=9){

            startPage = 1;
            endPage = totalPageNum;
        }else {
            startPage = pageNum -4;
            endPage = pageNum+4;

            if ( startPage <1){
                startPage =1;
                endPage  = startPage+8;
            }

            if ( endPage > totalPageNum){

                endPage  = totalPageNum;

                startPage = totalRecordsNum -8;

            }

        }



    }


    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public int getPreviousPageNum() {


        return pageNum - 1 > 0 ? pageNum - 1 : 1;
    }


    public void setPreviousPageNum(int previousPageNum) {
        this.previousPageNum = previousPageNum;
    }

    public int getNextPageNum() {
        return pageNum + 1 > totalPageNum ? totalPageNum : pageNum + 1;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }


    public List getReacords() {
        return reacords;
    }

    public void setReacords(List reacords) {
        this.reacords = reacords;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalRecordsNum() {
        return totalRecordsNum;
    }

    public void setTotalRecordsNum(int totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }
}
