{
	"error": 0,
	"message": "",
	"datas": {
		"requester": {
			"type": "text",
			"maxlength": 99,
			"size": 50,
			"autocomplete": "off",
			"label": "\u90ae\u7bb1\u5730\u5740",
			"name": "requester"
		},
		"title": {
			"type": "text",
			"maxlength": 120,
			"label": "\u6807\u9898",
			"name": "title",
			"required": true
		},
		"status": {
			"type": "dropdownlist",
			"items": [{
				"key": 0,
				"value": "\u5c1a\u672a\u53d7\u7406"
			},
			{
				"key": 1,
				"value": "\u53d7\u7406\u4e2d"
			},
			{
				"key": 2,
				"value": "\u7b49\u5f85\u56de\u590d"
			},
			{
				"key": 3,
				"value": "\u5df2\u89e3\u51b3"
			}],
			"label": "\u5de5\u5355\u72b6\u6001",
			"name": "status"
		},
		"linked_id": {
			"type": "dropdownlist",
			"items": [{
				"key": "",
				"value": "-"
			},
			{
				"key": 880,
				"value": "#711 api test"
			},
			{
				"key": 2498,
				"value": "#2379 \u6d4b\u8bd53"
			},
			{
				"key": 2507,
				"value": "#2388 \u6d4b\u8bd5\u6570\u636e2"
			},
			{
				"key": 2508,
				"value": "#2389 test"
			},
			{
				"key": 2511,
				"value": "#2392 \u6d4b\u8bd54"
			},
			{
				"key": 2514,
				"value": "#2395 \u65b0\u5de5\u535515110"
			}],
			"label": "\u5173\u8054\u5230\u6545\u969c",
			"name": "linked_id"
		},
		"due_date": {
			"type": "due_date",
			"label": "\u4efb\u52a1\u5230\u671f\u65f6\u95f4",
			"name": "due_date"
		},
		"group_id": {
			"type": "dropdownlist",
			"items": [{
				"key": "",
				"value": "-"
			},
			{
				"key": 165,
				"value": "test\u652f\u6301\u7ec412"
			},
			{
				"key": 200,
				"value": "KCHAT\u5de5\u5355\u5ba2\u670d\u7ec4"
			},
			{
				"key": 217,
				"value": "\u6280\u672f\u7ec4"
			},
			{
				"key": 219,
				"value": "\u7535\u8bdd\u8bed\u97f3\u5ba2\u670d\u7ec4"
			},
			{
				"key": 220,
				"value": "\u55ef\u55ef\u55ef"
			},
			{
				"key": 398,
				"value": "\u4f60\u7785\u5565\u54e6\uff01"
			},
			{
				"key": 401,
				"value": "\u4f60\u7785\u5565\u554a"
			},
			{
				"key": 423,
				"value": "14hour group"
			},
			{
				"key": 424,
				"value": "14hour group"
			},
			{
				"key": 425,
				"value": "test111"
			},
			{
				"key": 426,
				"value": "test"
			},
			{
				"key": 427,
				"value": "\u5ba2\u670d\u5c0f\u7ec4\u4e00"
			},
			{
				"key": 436,
				"value": "test"
			},
			{
				"key": 437,
				"value": "\u4e91\u5ba2\u670d1"
			},
			{
				"key": 449,
				"value": "\u6240\u6709"
			}],
			"label": "\u53d7\u7406\u5ba2\u670d\u7ec4",
			"name": "group_id"
		},
		"assignee_id": {
			"type": "dropdownlist",
			"items": [{
				"key": "",
				"value": "-"
			}],
			"label": "\u53d7\u7406\u5ba2\u670d",
			"name": "assignee_id"
		},
		"content": {
			"type": "textarea",
			"rows": 5,
			"cols": 100,
			"label": "\u95ee\u9898\u63cf\u8ff0",
			"name": "content",
			"required": true
		},
		"form_custom": [{
			"type": "multi_cascade",
			"items": [{
				"key": "",
				"value": "-",
				"sub_items": []
			},
			{
				"key": "shuzi",
				"value": "shuzi",
				"sub_items": ["111",
				"222"]
			},
			{
				"key": "zimu",
				"value": "zimu",
				"sub_items": ["aaaa",
				"bbb"]
			},
			{
				"key": "23",
				"value": "23",
				"sub_items": ["23223",
				"444444"]
			}],
			"cascade_id": null,
			"cascade_value": null,
			"label": "\u4e09\u7ea7\u7ea7\u8054",
			"name": "field_709",
			"subitems": [{
				"title": "23\/23223",
				"sub": [{
					"type": "text",
					"maxlength": 100,
					"size": 50,
					"is_time_field": true,
					"cascade_id": "709",
					"cascade_item": "23",
					"cascade_subitem": "23223",
					"label": "\u65f6\u95f4",
					"name": "field_56",
					"title": "23\/23223"
				},
				{
					"type": "text",
					"maxlength": 100,
					"size": 50,
					"cascade_id": "709",
					"cascade_item": "23",
					"cascade_subitem": "23223",
					"label": "text",
					"name": "field_726",
					"title": "23\/23223"
				},
				{
					"type": "text",
					"maxlength": 32,
					"size": 20,
					"cascade_id": "709",
					"cascade_item": "23",
					"cascade_subitem": "23223",
					"label": "\u6570\u5b57\u5b57\u6bb5",
					"name": "field_601",
					"title": "23\/23223"
				}]
			},
			{
				"title": "23\/444444",
				"sub": [{
					"type": "text",
					"maxlength": 100,
					"size": 50,
					"is_date_field": true,
					"cascade_id": "709",
					"cascade_item": "23",
					"cascade_subitem": "444444",
					"label": "\u8d2d\u4e70\u65e5\u671f",
					"name": "field_702",
					"title": "23\/444444"
				},
				{
					"type": "text",
					"maxlength": 100,
					"size": 50,
					"is_date_field": true,
					"cascade_id": "709",
					"cascade_item": "23",
					"cascade_subitem": "444444",
					"label": "nice",
					"name": "field_643",
					"title": "23\/444444"
				}]
			}]
		}]
	}
}