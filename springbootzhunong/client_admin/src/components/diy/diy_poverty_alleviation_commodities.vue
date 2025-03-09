<template>
	<el-form ref="form" :rules="rules" :model="form" status-icon label-width="80px">
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="店铺名称" prop="store_name">
						<el-input id="store_name" v-model="form['store_name']" placeholder="请输入店铺名称"
					v-if="user_group == '管理员' || (form['poverty_alleviation_commodities_id'] && $check_field('set','store_name') ) || $check_field('add','store_name')"></el-input>
				<div v-else-if="$check_field('get','store_name')">{{form['store_name']}}</div>
					</el-form-item>
		</el-col>
	
		<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
			<el-form-item label="点击数" prop="hits">
				<el-input-number id="hits" v-model="form['hits']"
					v-if="user_group == '管理员' || $check_field('set','hits')"></el-input-number>
				<div v-else-if="$check_field('get','hits')">{{form["hits"]}}</div>
			</el-form-item>
		</el-col>


		<el-col :xs="24" :sm="24" :lg="24" style="text-align: center;" class="el_form_btn_warp">
			<el-button type="primary" @click="submit()">提交</el-button>
			<el-button @click="cancel()">取消</el-button>
		</el-col>

	</el-form>
</template>

<script>
	import mixin from "../../mixins/component.js";

	export default {
		mixins: [mixin],
		props:{
			query: {
				type: Object,
				default: function(){
					return {
						"poverty_alleviation_commodities_id": 0
					}
				}
			},
			form_goods:{
				type: Object,
				default: function(){
					return {}
				}
			},
			func_check:{
				type: Function,
				default: function(fun){
					console.log("调试输出",fun);
				}
			},
			func_submit:{
				type: Function,
				default: function(fun){
					console.log("调试输出",fun);
				}
			}
		},
		data() {
			return {
				field: "poverty_alleviation_commodities_id",
				url_add: "~/api/poverty_alleviation_commodities/add?",
				url_set: "~/api/poverty_alleviation_commodities/set?",
				url_get_obj: "~/api/poverty_alleviation_commodities/get_obj?",
				url_upload: "~/api/poverty_alleviation_commodities/upload?",

				form: {
						"store_account": 0,
							"store_name":  '',
						"hits": 0,
				},

		
				rules: {
					"store_account": [     {required: true,message: '店铺账号不能为空'},  ],
					"store_name": [     {required: true,message: '店铺名称不能为空'},  ],
				}

			}
		},
		methods: {

			/**
			 * 请求列表前
			 * @param {Object} param
			 */
			get_list_before(param) {
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
									case "店铺账号":
							param["store_account"] = this.user.user_id;
							break;
											}
				}

				return param;
			},

	
	
		
	
	
			submit(){
				this.func_check(()=>{
					this.$refs["form"].validate((valid)} => {
						if (valid) {
							this.submit();
						} else {
							console.error('error 提交失败!!');
						}
					});
				})
			},

			submit_after(){
				var source_id = this.form_goods.source_id;
				if(source_id){
					this.func_submit();
				}else{
					this.$get('~/api/poverty_alleviation_commodities/get_obj?',this.form,(res)=>{
						if(res.result && res.result.obj){
							this.form_goods.source_id = res.result.obj["poverty_alleviation_commodities_id"];
							this.func_submit();
						}else{
							console.error(res.error);
						}

					})
				}
			}
		},
		created() {
				}
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
