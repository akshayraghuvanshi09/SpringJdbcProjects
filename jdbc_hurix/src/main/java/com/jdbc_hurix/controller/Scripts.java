package com.jdbc_hurix.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Scripts {
	static String st="<!DOCTYPE html>\r\n"
			+ "<html class=\"no-js\">\r\n"
			+ " <head> \r\n"
			+ "  <meta charset=\"utf-8\" /> \r\n"
			+ "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" /> \r\n"
			+ "  <meta name=\"description\" content=\"\" /> \r\n"
			+ "  <meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" /> \r\n"
			+ "  <script src=\"META-INF/data.js\"></script> \r\n"
			+ "  <link rel=\"stylesheet\" href=\"../sdk/0.0.2/css/styles.min.css\" /> \r\n"
			+ "  <script src=\"../sdk/0.0.2/src/kitaboo-0.0.2.js\"></script> \r\n"
			+ "  <script type=\"text/javascript\" src=\"../sdk/0.0.2/localization/modernizr.js\"></script> \r\n"
			+ "  <script type=\"text/javascript\" src=\"../sdk/0.0.2/localization/jquery_localize.js\"></script> \r\n"
			+ "  <script>\r\n"
			+ "            var cloudbook = \"\";\r\n"
			+ "            document.onreadystatechange = function() {\r\n"
			+ "            	if (document.readyState == \"complete\") {\r\n"
			+ "            		var config = {\r\n"
			+ "            			isKitabooSearchsupport : true,\r\n"
			+ "            			isminiplayer : true,\r\n"
			+ "            			isofflinechromesupport : false\r\n"
			+ "            		};\r\n"
			+ "            		window.book = new eBook(cloudbook, config);\r\n"
			+ "            \r\n"
			+ "            		book.Onaction(\"book:loadstart\", function() {\r\n"
			+ "            \r\n"
			+ "            		});\r\n"
			+ "            \r\n"
			+ "            		book.Onaction(\"book:loadend\", function() {\r\n"
			+ "            			\r\n"
			+ "            			window.book.getMetaData(function(data){\r\n"
			+ "        					document.getElementById('name').innerText = data.bookTitle;\r\n"
			+ "                            buildTOC();\r\n"
			+ "                    	});\r\n"
			+ "            		});\r\n"
			+ "            \r\n"
			+ "            		book.Onaction(\"book:chapterDisplayed\", function() {\r\n"
			+ "            			\r\n"
			+ "            			if(viewer.isMiniplayer){\r\n"
			+ "					\r\n"
			+ "								\r\n"
			+ "						\r\n"
			+ "            				var currentpage = window.viewer.currentChapter.Index;\r\n"
			+ "\r\n"
			+ "            				var total = window.viewer.chapter.length;\r\n"
			+ "							document.getElementById('count').innerText = \"\" + (currentpage + 1) + \" \" + window.localeJson.of+\" \"+ total;\r\n"
			+ "            				document.body.style.overflow =\"hidden\";\r\n"
			+ "            				document.body.style.margin = 0 ;\r\n"
			+ "            			}\r\n"
			+ "            \r\n"
			+ "            			if(window.viewer.doc  != undefined){\r\n"
			+ "                            var docWindow = window.viewer.doc.defaultView;\r\n"
			+ "                            \r\n"
			+ "                            var docBody = window.viewer.doc.body;\r\n"
			+ "                            docBody.click(function() {\r\n"
			+ "                                checkPanel();\r\n"
			+ "                                addFontStyle();\r\n"
			+ "                            });\r\n"
			+ "                            \r\n"
			+ "                        }\r\n"
			+ "						\r\n"
			+ "            			if(JSON.parse(\"true\") == true){\r\n"
			+ "            				$('#toppanel').css({\r\n"
			+ "        		                'display' :'none'\r\n"
			+ "        					});\r\n"
			+ "            			}\r\n"
			+ "            			$(docWindow).scroll(function() {\r\n"
			+ "						\r\n"
			+ "            				if ($(docWindow).scrollTop() == 0) {\r\n"
			+ "            			    	$('.maincontainer').css({\r\n"
			+ "            		                '-webkit-box-shadow': 'none',\r\n"
			+ "            						'-moz-box-shadow': 'none',\r\n"
			+ "            						'box-shadow': 'none',\r\n"
			+ "            						'-webkit-transition': 'box-shadow 0.3s',\r\n"
			+ "            						'transition': 'box-shadow 0.3s'\r\n"
			+ "            					});\r\n"
			+ "            			    } else {\r\n"
			+ "            			        $('.maincontainer').css({\r\n"
			+ "            		                '-webkit-box-shadow': 'inset 0px 5px 25px 5px rgba(99,96,86,1)',\r\n"
			+ "            						'-moz-box-shadow': ' 0px 5px  11px 1px  rgba(99,96,86,1)',\r\n"
			+ "            						'box-shadow': ' 0px 5px  11px 1px rgba(99,96,86,1)',\r\n"
			+ "            						'-webkit-transition': 'box-shadow 0.3s',\r\n"
			+ "            						'transition': 'box-shadow 0.3s'\r\n"
			+ "            					});\r\n"
			+ "            			    }\r\n"
			+ "            			});\r\n"
			+ "            \r\n"
			+ "            		\r\n"
			+ "            \r\n"
			+ "            			$('#tocchild').scroll(function() {\r\n"
			+ "            				if ($('#tocchild').scrollTop() == 0) {\r\n"
			+ "            					$('#tocchild').css({\r\n"
			+ "            		                '-webkit-box-shadow': 'none',\r\n"
			+ "            						'-moz-box-shadow': 'none',\r\n"
			+ "            						'box-shadow': 'none',\r\n"
			+ "            						'-webkit-transition': 'box-shadow 0.3s',\r\n"
			+ "            						'transition': 'box-shadow 0.3s'\r\n"
			+ "            					});\r\n"
			+ "            			    } else {\r\n"
			+ "            					$('#tocchild').css({\r\n"
			+ "            		                '-webkit-box-shadow': 'inset 0px 10px 10px -3px rgba(99,96,86,0.3)',\r\n"
			+ "            						'-moz-box-shadow': 'inset 0px 10px 10px -3px rgba(99,96,86,0.3)',\r\n"
			+ "            						'box-shadow': 'inset 0px 10px 10px -3px rgba(99,96,86,0.3)',\r\n"
			+ "            						'-webkit-transition': 'box-shadow 0.3s',\r\n"
			+ "            						'transition': 'box-shadow 0.3s'\r\n"
			+ "            					});\r\n"
			+ "            			    }\r\n"
			+ "            			});\r\n"
			+ "            \r\n"
			+ "            			\r\n"
			+ "            		    $('.maincontainer iframe').contents().find(\"head\")\r\n"
			+ "            		      .append($(\"<style type='text/css'>  ::-webkit-scrollbar {	width: 10px;}::-webkit-scrollbar-track {-webkit-box-shadow: inset 0 0 0;-webkit-border-radius: 0px;	border-radius: 0px;	outline: 1px solid;}::-webkit-scrollbar-thumb {-webkit-border-radius: 0px;	border-radius: 0px;	background: #d6d6d6;-webkit-box-shadow: inset 0 0 6px #d6d6d6;}::-webkit-scrollbar-thumb:window-inactive {background: #d6d6d6;}  </style>\"\r\n"
			+ "            		    ));\r\n"
			+ "            \r\n"
			+ "            		    \r\n"
			+ "            \r\n"
			+ "            		    $('#toppanel, #bottompanal').on('click', function(event) {\r\n"
			+ "            		    	if (event.target == $('.toc')[0] || event.target == $('#menu')[0]) {\r\n"
			+ "            		    		event.preventDefault();\r\n"
			+ "            		    		event.stopPropagation();\r\n"
			+ "            		    	} else {\r\n"
			+ "            				    checkPanel();\r\n"
			+ "            		    	}\r\n"
			+ "            		    });\r\n"
			+ "            		});\r\n"
			+ "            	}\r\n"
			+ "            }\r\n"
			+ "            \r\n"
			+ "            function checkPanel() {\r\n"
			+ "            	if ($('#tocitems').hasClass('isOpened') && document.getElementById('tocitems').style.display == 'block') {\r\n"
			+ "            		document.getElementById('tocitems').style.display = 'none';\r\n"
			+ "            		document.getElementsByClassName(\"toc\")[0].classList.remove(\"highlightBackground\");\r\n"
			+ "               	} else {\r\n"
			+ "               		$('#tocitems').removeClass('isOpened');\r\n"
			+ "               	}\r\n"
			+ "            }\r\n"
			+ "            \r\n"
			+ "            var toctreeview;\r\n"
			+ "            function onClose() {\r\n"
			+ "            	alert(\"Please close the window\");\r\n"
			+ "            }\r\n"
			+ "            \r\n"
			+ "            function buildTOC(){\r\n"
			+ "            \r\n"
			+ "            	var tocitems;\r\n"
			+ "            	var elements = document.getElementById('tocholder');\r\n"
			+ "            \r\n"
			+ "            	elements.innerHTML = \"<div id='tree'></div>\";\r\n"
			+ "				\r\n"
			+ "				tocitems = window.book.bookdata.toc;\r\n"
			+ "		\r\n"
			+ "            	var tree = tocitems;\r\n"
			+ "            	var treeLength = tree.length;\r\n"
			+ "            \r\n"
			+ "            	toctreeview = new TreeView(tree, 'tree');\r\n"
			+ "            \r\n"
			+ "    			switch (true) {\r\n"
			+ "    		        case (treeLength == 0):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 90px; text-align: center';\r\n"
			+ "    		            document.getElementById(\"tocchild\").innerHTML = '<span class=\"noResultFound\">Results not found.</span>';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 1):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 65px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 2):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 110px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 3):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 160px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 4):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 210px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 5):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 260px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 6):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 310px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 7):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 360px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 8):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 420px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        case (treeLength == 9):\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 480px';\r\n"
			+ "    		            break;\r\n"
			+ "    		        default:\r\n"
			+ "    		            document.getElementById(\"tocitems\").style.cssText += 'height: 530px';\r\n"
			+ "    		    }\r\n"
			+ "    \r\n"
			+ "    			toctreeview.on('select', function(e) {\r\n"
			+ "    				$('.tree-leaf-text').removeClass('bold_style');\r\n"
			+ "    				$(e.target.target).addClass('bold_style');\r\n"
			+ "    				loadChapterFromTOC(e.data);\r\n"
			+ "    				document.getElementById('tocitems').style.display = 'none';\r\n"
			+ "    				document.getElementsByClassName(\"toc\")[0].classList.remove(\"highlightBackground\");\r\n"
			+ "    			});\r\n"
			+ "    			toctreeview.on('expand', function(e) {\r\n"
			+ "    				console.log('expand');\r\n"
			+ "    			});\r\n"
			+ "    			toctreeview.on('collapse', function() {\r\n"
			+ "    				console.log('collapse');\r\n"
			+ "    			});\r\n"
			+ "    			toctreeview.on('expandAll', function() {\r\n"
			+ "    				console.log('expand all');\r\n"
			+ "    			});\r\n"
			+ "    			toctreeview.on('collapseAll', function() {\r\n"
			+ "    				console.log('collapse all');\r\n"
			+ "    			});\r\n"
			+ "            }	\r\n"
			+ "            \r\n"
			+ "            function toggleToc() {\r\n"
			+ "            	if (document.getElementById('tocitems').style.display == \"\" || document.getElementById('tocitems').style.display == 'none') {\r\n"
			+ "            		document.getElementById('tocitems').classList.add(\"isOpened\");\r\n"
			+ "            		document.getElementById('tocitems').style.display = 'block';\r\n"
			+ "            		document.getElementsByClassName(\"toc\")[0].classList.add(\"highlightBackground\");\r\n"
			+ "					buildTOC();\r\n"
			+ "            		addFontStyle();\r\n"
			+ "            	} else {\r\n"
			+ "            		document.getElementById('tocitems').classList.remove(\"isOpened\");\r\n"
			+ "            		document.getElementById('tocitems').style.display = 'none';\r\n"
			+ "            		document.getElementsByClassName(\"toc\")[0].classList.remove(\"highlightBackground\");\r\n"
			+ "            	}\r\n"
			+ "            \r\n"
			+ "            }\r\n"
			+ "            \r\n"
			+ "            function addFontStyle() {\r\n"
			+ "            	var itemlist = $('[data-item]');\r\n"
			+ "            	$('.tree-leaf-text').removeClass('bold_style');\r\n"
			+ "            	for (var i = 0; i < itemlist.length; i++) {\r\n"
			+ "            		if (viewer.currentChapter.Index == JSON.parse($(itemlist[i]).attr('data-item')).spinePos) {\r\n"
			+ "            			var itemLabel = JSON.parse($(itemlist[i]).attr('data-item')).label;\r\n"
			+ "            			$('.left #name').html(itemLabel);\r\n"
			+ "            			$(itemlist[i]).removeClass('bold_style');\r\n"
			+ "            			$($(itemlist[i])[0]).addClass('bold_style');\r\n"
			+ "            		} else {\r\n"
			+ "            			$(itemlist[i]).removeClass('bold_style');\r\n"
			+ "            		}\r\n"
			+ "            	}\r\n"
			+ "            }\r\n"
			+ "			\r\n"
			+ "			$(document).ready(function(){\r\n"
			+ "				var opts = { language: \"en\",pathPrefix:\"OEBPS/localization/\"};				\r\n"
			+ "				$(\"[data-localize]\").localize(\"player\", opts);\r\n"
			+ "		    });\r\n"
			+ "   \r\n"
			+ "						\r\n"
			+ "						\r\n"
			+ "        </script> \r\n"
			+ " </head> \r\n"
			+ " <body> \r\n"
			+ "  <div class=\"toppanel\" id=\"toppanel\" style=\"display: none;\"> \r\n"
			+ "   <div class=\"left\"> \r\n"
			+ "    <span class=\"centertext\" id=\"name\">Kitaboo widget</span> \r\n"
			+ "   </div> \r\n"
			+ "   <div class=\"rightclose\" onclick=\"onClose()\" style=\"display: none;\"> \r\n"
			+ "    <img class=\"centertext icon-video_player_close\" id=\"close\" src=\"../sdk/0.0.2/img/close.svg\" /> \r\n"
			+ "   </div> \r\n"
			+ "  </div> \r\n"
			+ "  <div class=\"tocpanel\" id=\"tocitems\"> \r\n"
			+ "   <div id=\"tocchild\"> \r\n"
			+ "    <div class=\"tocloader\"></div> \r\n"
			+ "    <div class=\"item\" id=\"tocholder\"></div> \r\n"
			+ "   </div> \r\n"
			+ "  </div> \r\n"
			+ "  <div class=\"maincontainer\"> \r\n"
			+ "   <div class=\"loader\" id=\"loader\"> \r\n"
			+ "    <img alt=\"loader\" src=\"../sdk/0.0.2/img/loader.gif\" /> \r\n"
			+ "   </div> \r\n"
			+ "   <div class=\"epubviewer\" id=\"epubviewer\"></div> \r\n"
			+ "  </div> \r\n"
			+ "  <div class=\"bottompanal\" id=\"bottompanal\"> \r\n"
			+ "   <div class=\"toc\" onclick=\"toggleToc()\"> \r\n"
			+ "    <img class=\"centertext icon-toc\" id=\"menu\" src=\"../sdk/0.0.2/img/TOC.svg\" /> \r\n"
			+ "   </div> \r\n"
			+ "   <div class=\"pagenavigation\"> \r\n"
			+ "    <div id=\"prev\" class=\"arrow \" onclick=\"previousChapter()\"> \r\n"
			+ "     <img class=\"centertext icon-prev_page_icon\" src=\"../sdk/0.0.2/img/back.svg\" /> \r\n"
			+ "    </div> \r\n"
			+ "    <div class=\"label\"> \r\n"
			+ "     <span class=\"centertext\" id=\"count\">0</span> \r\n"
			+ "    </div> \r\n"
			+ "    <div id=\"next\" class=\"arrow\" onclick=\"nextChapter()\"> \r\n"
			+ "     <img class=\"centertext icon-next_page_icon\" src=\"../sdk/0.0.2/img/next.svg\" /> \r\n"
			+ "    </div> \r\n"
			+ "   </div> \r\n"
			+ "  </div>   \r\n"
			+ " </body>\r\n"
			+ "</html>";

	public static void readFileHt() throws IOException {
		String content = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("D:\\filter_html_file\\ES_2491\\index.html"));
			String str;
			while ((str = in.readLine()) != null) {
				content += str;
			}
			System.out.println(content);
			String replaceAll = content.replaceAll("sdk/", "../sdk/");
			System.err.println(replaceAll);
			overRiedHtml(replaceAll);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block e.printStackTrace(); }

		}

	}
	
	public static void overRiedHtml(String htmlContenct) {
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
		    fWriter = new FileWriter("D:\\filter_html_file\\ES_2491\\index.html");
		    
		    writer = new BufferedWriter(fWriter);
		    writer.write(st);
		    writer.newLine(); //this is not actually needed for html files - can make your code more readable though 
		    writer.close(); //make sure you close the writer object 
		} catch (Exception e) {
		  //catch any exceptions here
		}
	}
	
	public static void main(String[] args) {

		try {
			Scripts.readFileHt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try { Path temp = Files.move(Paths.get("D:\\filter_html_file\\ES_2491\\sdk"),
		 * Paths.get("D:\\filter_html_file\\sdk"));
		 * 
		 * if (temp != null) {
		 * System.out.println("File renamed and moved successfully"); } else {
		 * System.out.println("Failed to move the file"); }
		 * 
		 * }catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}
}
