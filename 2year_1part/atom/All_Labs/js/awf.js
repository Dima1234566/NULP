
function ReadOflineNews() {if (window.navigator.onLine) {
  len = localStorage.length + 1;

  for (var k = 1; k < len; k++) {

    news = JSON.parse(localStorage.getItem(k));
    if (news[0].name != null) {
      $("#news_list").prepend("<li class=\"list-group-item col-sm-4 thumbnail\">\n" +
        "    <article class=\"element\">\n" +
        "        <div  class=\"excerpt\">\n" +
        "             <p>" + "<strong class=\"title\"></strong>" + "</p>\n" +
        "            <p class=\"comments news\"></p>\n" +
        "            <p class=\"time\"></p>\n" +
        "        </div>\n" +
        "    </article>\n" +
        "</li>");

      $('#news_list li:first .title').append(news[0].name);
      $('#news_list li:first .comments').append(news[0].comments);
      $('#news_list li:first .time').append(news[0].time);

      localStorage.removeItem(k);
    }
  }
}

}
ReadOflineNews();
