<%--
  Created by IntelliJ IDEA.
  User: AlexY
  Date: 2016/7/29
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>




<%--分页开始--%>


第${page.pageNum}页/共${page.totalPageNum}页 &nbsp;&nbsp;

<a href="${pageContext.request.contextPath}${page.url}">首页</a>
<a href="${pageContext.request.contextPath}${page.url}&num=${page.previousPageNum}">上一页</a>
<a href="${pageContext.request.contextPath}${page.url}&num=${page.nextPageNum}">下一页</a>


<select id="s1">

    <c:forEach begin="1" end="${page.totalPageNum}" var="num">

        <option value="${num}"


            <%--将当前也选中--%>
            ${page.pageNum==num? ' selected="selected"':''}        >${num}</option>


    </c:forEach>

</select>

<%--分页结束--%>




<%--显示页码（1，2，3，4，..，10）--%>
<c:forEach begin="${page.startPage}" end="${page.endPage}" var="num">

    <a href="${pageContext.request.contextPath}${page.url}&num=${num}">${num}</a>



</c:forEach>



<%--第二种方法：适用于页面多的情况--%>

<input type="text" size="3" id="inputPage" value="">
<input type="button" id="bt1" value="跳转">



<script>


    //        第一种页面跳转方式
    window.onload = function () {

//        选择页码后即开始跳转
        document.getElementById("s1").onchagne = function () {
            window.location.href = "${pageContext.request.contextPath}${page.url}&num=" + this.value;
        }

    }



    //        第二种页面跳转方式
    window.onload = function () {


        document.getElementById("bt1").onclick = function () {

            var num = document.getElementById("inputPage");


//                 验证
            if (!/^[1-9][0-9]*$/.test(num.value)) {
                alert("请输入正确的页码");

                return;
            }


            if (num.value > ${page.totalPageNum}) {
                alert(" 页码不能超过总页数");

                return;
            }


            window.location.href = "${pageContext.request.contextPath}${page.url}&num=" + this.value;
        }


    }


</script>