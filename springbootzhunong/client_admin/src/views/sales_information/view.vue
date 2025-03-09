<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','store_account') || $check_field('add','store_account') || $check_field('set','store_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺账号" prop="store_account">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_store_account(form['store_account']) }}
							<!--<el-input id="business_name" v-model="form['store_account']" placeholder="请输入店铺账号"-->
							<!--v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','store_account')) || (!form['sales_information_id'] && $check_field('add','store_account'))" :disabled="disabledObj['store_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','store_account')">{{form['store_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','store_account')) || (!form['sales_information_id'] && $check_field('add','store_account'))" id="store_account" v-model="form['store_account']" :disabled="disabledObj['store_account_isDisabled']">
								<el-option v-for="o in list_user_store_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','store_account')" id="store_account" v-model="form['store_account']" :disabled="true">
								<el-option v-for="o in list_user_store_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="store_account" v-model="form['store_account']" :disabled="disabledObj['store_account_isDisabled']">
							<el-option v-for="o in list_user_store_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','store_name') || $check_field('add','store_name') || $check_field('set','store_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="店铺名称" prop="store_name">
												<el-input id="store_name" v-model="form['store_name']" placeholder="请输入店铺名称"
							  v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','store_name')) || (!form['sales_information_id'] && $check_field('add','store_name'))" :disabled="disabledObj['store_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','store_name')">{{form['store_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_number') || $check_field('add','order_number') || $check_field('set','order_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单编号" prop="order_number">
												<el-input id="order_number" v-model="form['order_number']" placeholder="请输入订单编号"
							  v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','order_number')) || (!form['sales_information_id'] && $check_field('add','order_number'))" :disabled="disabledObj['order_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','order_number')">{{form['order_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_date') || $check_field('add','order_date') || $check_field('set','order_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单日期" prop="order_date">
								<el-date-picker :disabled="disabledObj['order_date_isDisabled']" v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','order_date')) || (!form['sales_information_id'] && $check_field('add','order_date'))" id="order_date"
						v-model="form['order_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','order_date')">{{form['order_date']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','sales_month') || $check_field('add','sales_month') || $check_field('set','sales_month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="销售月份" prop="sales_month">
												<el-input id="sales_month" v-model="form['sales_month']" placeholder="请输入销售月份"
							  v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','sales_month')) || (!form['sales_information_id'] && $check_field('add','sales_month'))" :disabled="disabledObj['sales_month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','sales_month')">{{form['sales_month']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','order_amount') || $check_field('add','order_amount') || $check_field('set','order_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="订单金额" prop="order_amount">
								<el-input-number id="order_amount" v-model.number="form['order_amount']"
						v-if="user_group === '管理员' || (form['sales_information_id'] && $check_field('set','order_amount')) || (!form['sales_information_id'] && $check_field('add','order_amount'))" :disabled="disabledObj['order_amount_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','order_amount')">{{form['order_amount']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "sales_information_id",
				url_add: "~/api/sales_information/add?",
				url_set: "~/api/sales_information/set?",
				url_get_obj: "~/api/sales_information/get_obj?",
				url_upload: "~/api/sales_information/upload?",

				query: {
					"sales_information_id": 0,
				},

				form: {
								"store_account": 0, // 店铺账号
										"store_name":  '', // 店铺名称
										"order_number":  '', // 订单编号
										"order_date":  '', // 订单日期
										"sales_month":  '', // 销售月份
										"order_amount":  0, // 订单金额
											"sales_information_id": 0, // ID
						
				},
				disabledObj:{
								"store_account_isDisabled": false,
										"store_name_isDisabled": false,
										"order_number_isDisabled": false,
										"order_date_isDisabled": false,
										"sales_month_isDisabled": false,
					          			"order_amount_isDisabled": false,
										},

	
					// 用户列表
				list_user_store_account: [],
						// 用户组
				group_user_store_account: "",
				
		
		
		
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取卖家用户列表
			 */
			async get_list_user_store_account() {
                // if(this.user_group !== "管理员" && this.form["store_account"] === 0) {
                //     this.form["store_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=卖家");
                if(json.result && json.result.list){
                    this.list_user_store_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取卖家用户组
			 */
			async get_group_user_store_account() {
							this.form["store_account"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=卖家");
				if(json.result && json.result.obj){
					this.group_user_store_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_store_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_store_account.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["store_account"] = id
									_this.disabledObj['store_account' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "store_account") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_store_account(id){
				var obj = this.list_user_store_account.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
													
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
								        if (this.form["order_date"].indexOf("-")===-1){
          this.form["order_date"] = this.$toTime(parseInt(this.form["order_date"]),"yyyy-MM-dd")
        }
									$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


											        if(this.form["order_date"]=="0000-00-00"){
          this.form["order_date"] = null;
        }
				if(parseInt(this.form["order_date"]) > 9999){
					this.form["order_date"] = this.$toTime(parseInt(this.form["order_date"]),"yyyy-MM-dd")
				}
								


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																								return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/sales_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/sales_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_store_account();
					this.get_group_user_store_account();
															},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
