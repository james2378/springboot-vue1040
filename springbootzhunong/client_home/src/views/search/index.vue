<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 商品搜索结果 -->
			  <list_result_search
				:list="result_goods"
				title="扶贫商品"
				source_table="goods"
			  ></list_result_search>

				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="扶贫资讯"
				source_table="article"
			  ></list_result_search>


						  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_user_name"
				title="普通用户用户姓名"
				source_table="ordinary_users"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_user_gender"
				title="普通用户用户性别"
				source_table="ordinary_users"
			  ></list_result_search>
									  <list_result_search
				v-if="$check_action('/seller/list', 'get')"
				:list="result_seller_store_name"
				title="卖家店铺名称"
				source_table="seller"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/poverty_alleviation_commodities/list', 'get')"
				:list="result_poverty_alleviation_commodities_store_name"
				title="扶贫商品店铺名称"
				source_table="poverty_alleviation_commodities"
			  ></list_result_search>
												  <list_result_search
				v-if="$check_action('/logistics_information/list', 'get')"
				:list="result_logistics_information_store_name"
				title="物流信息店铺名称"
				source_table="logistics_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/logistics_information/list', 'get')"
				:list="result_logistics_information_order_number"
				title="物流信息订单编号"
				source_table="logistics_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/logistics_information/list', 'get')"
				:list="result_logistics_information_logistics_status"
				title="物流信息物流状态"
				source_table="logistics_information"
			  ></list_result_search>
																		  <list_result_search
				v-if="$check_action('/receiving_information/list', 'get')"
				:list="result_receiving_information_store_name"
				title="收货信息店铺名称"
				source_table="receiving_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/receiving_information/list', 'get')"
				:list="result_receiving_information_order_number"
				title="收货信息订单编号"
				source_table="receiving_information"
			  ></list_result_search>
																														  <list_result_search
				v-if="$check_action('/after_sales_information/list', 'get')"
				:list="result_after_sales_information_store_name"
				title="售后信息店铺名称"
				source_table="after_sales_information"
			  ></list_result_search>
								  <list_result_search
				v-if="$check_action('/after_sales_information/list', 'get')"
				:list="result_after_sales_information_order_number"
				title="售后信息订单编号"
				source_table="after_sales_information"
			  ></list_result_search>
											  <list_result_search
				v-if="$check_action('/after_sales_information/list', 'get')"
				:list="result_after_sales_information_after_sales_type"
				title="售后信息售后类型"
				source_table="after_sales_information"
			  ></list_result_search>
															  <list_result_search
				v-if="$check_action('/sales_information/list', 'get')"
				:list="result_sales_information_store_name"
				title="销售信息店铺名称"
				source_table="sales_information"
			  ></list_result_search>
														  <list_result_search
				v-if="$check_action('/sales_information/list', 'get')"
				:list="result_sales_information_sales_month"
				title="销售信息销售月份"
				source_table="sales_information"
			  ></list_result_search>
									</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_goods": [],
	  "result_article": [],
						"result_ordinary_users_user_name":[],
								"result_ordinary_users_user_gender":[],
									"result_seller_store_name":[],
															"result_poverty_alleviation_commodities_store_name":[],
												"result_logistics_information_store_name":[],
														"result_logistics_information_order_number":[],
														"result_logistics_information_logistics_status":[],
																		"result_receiving_information_store_name":[],
														"result_receiving_information_order_number":[],
																														"result_after_sales_information_store_name":[],
								"result_after_sales_information_order_number":[],
											"result_after_sales_information_after_sales_type":[],
															"result_sales_information_store_name":[],
														"result_sales_information_sales_month":[],
							};
  },
  methods: {
	/**
	 * 获取${fmodel.filter.cart_name}
	 */
	get_goods() {
	  this.$get("~/api/goods/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_goods = json.result.list;
		}
	  });
	},
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},

				/**
	 * 获取user_name
	 */
	get_ordinary_users_user_name(){
		let url = "~/api/ordinary_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_user_name = json.result.list;
			result_ordinary_users_user_name.map(o => o.title = o['user_name'])
	  			this.result_ordinary_users_user_name = result_ordinary_users_user_name
		 	}
		});
	},
						/**
	 * 获取user_gender
	 */
	get_ordinary_users_user_gender(){
		let url = "~/api/ordinary_users/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "user_gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_user_gender = json.result.list;
			result_ordinary_users_user_gender.map(o => o.title = o['user_gender'])
	  			this.result_ordinary_users_user_gender = result_ordinary_users_user_gender
		 	}
		});
	},
							/**
	 * 获取store_name
	 */
	get_seller_store_name(){
		let url = "~/api/seller/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_seller_store_name = json.result.list;
			result_seller_store_name.map(o => o.title = o['store_name'])
	  			this.result_seller_store_name = result_seller_store_name
		 	}
		});
	},
													/**
	 * 获取store_name
	 */
	get_poverty_alleviation_commodities_store_name(){
		let url = "~/api/poverty_alleviation_commodities/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_poverty_alleviation_commodities_store_name = json.result.list;
			result_poverty_alleviation_commodities_store_name.map(o => o.title = o['store_name'])
	  			this.result_poverty_alleviation_commodities_store_name = result_poverty_alleviation_commodities_store_name
		 	}
		});
	},
										/**
	 * 获取store_name
	 */
	get_logistics_information_store_name(){
		let url = "~/api/logistics_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_logistics_information_store_name = json.result.list;
			result_logistics_information_store_name.map(o => o.title = o['store_name'])
	  			this.result_logistics_information_store_name = result_logistics_information_store_name
		 	}
		});
	},
												/**
	 * 获取order_number
	 */
	get_logistics_information_order_number(){
		let url = "~/api/logistics_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "order_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_logistics_information_order_number = json.result.list;
			result_logistics_information_order_number.map(o => o.title = o['order_number'])
	  			this.result_logistics_information_order_number = result_logistics_information_order_number
		 	}
		});
	},
												/**
	 * 获取logistics_status
	 */
	get_logistics_information_logistics_status(){
		let url = "~/api/logistics_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "logistics_status": this.query.word }, (json) => {
		  if (json.result) {
			var result_logistics_information_logistics_status = json.result.list;
			result_logistics_information_logistics_status.map(o => o.title = o['logistics_status'])
	  			this.result_logistics_information_logistics_status = result_logistics_information_logistics_status
		 	}
		});
	},
																/**
	 * 获取store_name
	 */
	get_receiving_information_store_name(){
		let url = "~/api/receiving_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_receiving_information_store_name = json.result.list;
			result_receiving_information_store_name.map(o => o.title = o['store_name'])
	  			this.result_receiving_information_store_name = result_receiving_information_store_name
		 	}
		});
	},
												/**
	 * 获取order_number
	 */
	get_receiving_information_order_number(){
		let url = "~/api/receiving_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "order_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_receiving_information_order_number = json.result.list;
			result_receiving_information_order_number.map(o => o.title = o['order_number'])
	  			this.result_receiving_information_order_number = result_receiving_information_order_number
		 	}
		});
	},
																												/**
	 * 获取store_name
	 */
	get_after_sales_information_store_name(){
		let url = "~/api/after_sales_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_after_sales_information_store_name = json.result.list;
			result_after_sales_information_store_name.map(o => o.title = o['store_name'])
	  			this.result_after_sales_information_store_name = result_after_sales_information_store_name
		 	}
		});
	},
						/**
	 * 获取order_number
	 */
	get_after_sales_information_order_number(){
		let url = "~/api/after_sales_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "order_number": this.query.word }, (json) => {
		  if (json.result) {
			var result_after_sales_information_order_number = json.result.list;
			result_after_sales_information_order_number.map(o => o.title = o['order_number'])
	  			this.result_after_sales_information_order_number = result_after_sales_information_order_number
		 	}
		});
	},
									/**
	 * 获取after_sales_type
	 */
	get_after_sales_information_after_sales_type(){
		let url = "~/api/after_sales_information/get_list?like=0";
				url = url+"&examine_state=已通过";
				this.$get(url, { page: 1, size: 10, "after_sales_type": this.query.word }, (json) => {
		  if (json.result) {
			var result_after_sales_information_after_sales_type = json.result.list;
			result_after_sales_information_after_sales_type.map(o => o.title = o['after_sales_type'])
	  			this.result_after_sales_information_after_sales_type = result_after_sales_information_after_sales_type
		 	}
		});
	},
													/**
	 * 获取store_name
	 */
	get_sales_information_store_name(){
		let url = "~/api/sales_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "store_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_sales_information_store_name = json.result.list;
			result_sales_information_store_name.map(o => o.title = o['store_name'])
	  			this.result_sales_information_store_name = result_sales_information_store_name
		 	}
		});
	},
												/**
	 * 获取sales_month
	 */
	get_sales_information_sales_month(){
		let url = "~/api/sales_information/get_list?like=0";
				this.$get(url, { page: 1, size: 10, "sales_month": this.query.word }, (json) => {
		  if (json.result) {
			var result_sales_information_sales_month = json.result.list;
			result_sales_information_sales_month.map(o => o.title = o['sales_month'])
	  			this.result_sales_information_sales_month = result_sales_information_sales_month
		 	}
		});
	},
						
  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_goods();
	this.get_article();
					this.get_ordinary_users_user_name();
							this.get_ordinary_users_user_gender();
								this.get_seller_store_name();
														this.get_poverty_alleviation_commodities_store_name();
											this.get_logistics_information_store_name();
													this.get_logistics_information_order_number();
													this.get_logistics_information_logistics_status();
																	this.get_receiving_information_store_name();
													this.get_receiving_information_order_number();
																													this.get_after_sales_information_store_name();
							this.get_after_sales_information_order_number();
										this.get_after_sales_information_after_sales_type();
														this.get_sales_information_store_name();
													this.get_sales_information_sales_month();
						  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_goods();
	  this.get_article();
				  this.get_ordinary_users_user_name();
						  this.get_ordinary_users_user_gender();
							  this.get_seller_store_name();
													  this.get_poverty_alleviation_commodities_store_name();
										  this.get_logistics_information_store_name();
												  this.get_logistics_information_order_number();
												  this.get_logistics_information_logistics_status();
																  this.get_receiving_information_store_name();
												  this.get_receiving_information_order_number();
																												  this.get_after_sales_information_store_name();
						  this.get_after_sales_information_order_number();
									  this.get_after_sales_information_after_sales_type();
													  this.get_sales_information_store_name();
												  this.get_sales_information_sales_month();
							},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
