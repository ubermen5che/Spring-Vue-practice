<template>
  <div>
    <h2>게시판 리스트</h2>

    <div class="searchWrap">
      <input type="text" v-model="keyword" @keyup.enter="fnSearch" /><a href="javascript:;" @click="fnSearch" class="btnSearch btn">검색</a>
    </div>

    <div class="listWrap">
      <table class="tbList">
        <colgroup>
          <col width="6%" />
          <col width="*" />
          <col width="10%" />
          <col width="15%" />
        </colgroup>
        <tr>
          <th>no</th>
          <th>제목</th>
          <th>아이디</th>
          <th>날짜</th>
        </tr>
        <tr v-for="(row, idx) in list" :key="idx">
          <td>{{row.id}}</td>
          <td class="txt_left"><a href="javascript:;" @click="fnView(`${row.id}`)">{{row.subject}}</a></td>
          <td>{{row.type}}</td>
          <td>{{row.regDate.substring(0,10)}}</td>
        </tr>
        <tr v-if="list.length == 0">
          <td colspan="4">데이터가 없습니다.</td>
        </tr>
      </table>
    </div>

    <div class="pagination" v-if="paging.totalCount > 0">
      <a href="javascript:;" @click="fnPage(1)" class="first">&lt;&lt;</a>
      <a href="javascript:;" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)"  class="prev">&lt;</a>
      <template v-for=" (n,index) in paginavigation()">
        <template v-if="paging.page==n">
          <strong :key="index">{{n}}</strong>
        </template>
        <template v-else>
          <a href="javascript:;" @click="fnPage(`${n}`)" :key="index">{{n}}</a>
        </template>
      </template>
      <a href="javascript:;" v-if="paging.totalPage > paging.endPage" @click="fnPage(`${paging.endPage+1}`)"  class="next">&gt;</a>
      <a href="javascript:;" @click="fnPage(`${paging.totalPage}`)" class="last">&gt;&gt;</a>
    </div>

    <div class="btnRightWrap">
      <a @click="fnAdd" class="btn">등록</a>
    </div>
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return{
      body:'' //리스트 페이지 데이터전송
      ,board_code:'news' //게시판코드
      ,list:'' //리스트 데이터 post들의 정보를 담음
      ,no:'' //게시판 숫자처리
      ,paging:'' //페이징 데이터
      ,start_page:'' //시작페이지
      ,page:this.$route.query.page ? this.$route.query.page:1 // http://127.0.0.1:8080/#/board/list?page=1 형식으로 나타남. $route.query.page 명령시 1반환됨.
      ,keyword:this.$route.query.keyword
      ,paginavigation:function() { //페이징 처리 for문 커스텀
        var pageNumber = [];
        var start_page = this.paging.startPage;
        var end_page = this.paging.endPage;
        for (var i = start_page; i <= end_page; i++) pageNumber.push(i);
        return pageNumber;
      }
    }
  }
  ,mounted() { //페이지 시작하면은 자동 함수 실행
    this.fnGetList();
  }
  , methods:{
    fnGetList() { //데이터 가져오기 함수
      this.body = { // 데이터 전송
        boardCode:"news"
        ,keyword:this.keyword
        ,page:this.page
      }
      this.$axios.get('http://localhost:8080/api/board',{params:this.body})
        .then((res)=>{
          if(res.data.success) {
            this.list = res.data.pagingInfo.pl;
            this.paging = res.data.pagingInfo;
            this.no = this.paging.totalCount - ((this.paging.page-1) * this.paging.ipp);
          } else {
            alert("실행중 실패했습니다.\n다시 이용해 주세요.");
          }
        })
        .catch((err)=>{
          console.log(err);
        })
    }
    ,fnAdd() {
      this.$router.push("./write");
    }
    ,getList() {
      this.$axios.get("http://localhost:8000/api/board")
        .then((res)=>{
          console.log(res);
        })
        .then((err)=>{
          console.log(err);
        })
    }
    ,fnSearch() { //검색
      this.paging.page = 1;
      this.fnGetList();
    }
    , fnPage(n) {//페이징 이
      if(this.page != n) {
        this.page = n;
        this.fnGetList();
      }
    }
    , fnView(id){
      this.body.id = id;
      this.$router.push({path: './view', query: this.body});
    }
  }
}
</script>

<style scoped>
.searchWrap{border:1px solid #888; border-radius:5px; text-align:center; padding:20px 0; margin-bottom:40px;}
.searchWrap input{width:60%; height:36px; border-radius:3px; padding:0 10px; border:1px solid #888;}
.searchWrap .btnSearch{display:inline-block; margin-left:10px;}
.tbList th{border-top:1px solid #888;}
.tbList th, .tbList td{border-bottom:1px solid #eee; padding:5px 0;}
.tbList td.txt_left{text-align:left;}
.btnRightWrap{text-align:right; margin:10px 0 0 0;}

.pagination{margin:20px 0 0 0; text-align:center;}
.first, .prev, .next, .last{border:1px solid #666; margin:0 5px;}
.pagination span{display:inline-block; padding:0 5px; color:#333;}
.pagination a{text-decoration:none; display:inline-block; padding:0 5px; color:#666;}
</style>
