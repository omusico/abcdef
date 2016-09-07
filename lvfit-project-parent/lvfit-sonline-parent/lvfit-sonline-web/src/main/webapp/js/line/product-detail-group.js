(function() {
    var calendar = window.lineDetail.calendar
      , util = window.lineDetail.util
      , config = window.lineDetail.config;
    var readyCallBack = function(e) {
        var $navigateHeader = $("#product-detail-header")
          , navBarHeight = $navigateHeader.height()
          , $navigateList = $("#navigate-list")
          , $navigateLinkCollection = $navigateList.find("a")
          , $win = $(window)
          , $trafficTypeCollection = $("#traffic-type").find("li")
          , $trafficType = $(".traffic-type")
          , $trafficContainerCollection = $("#traffic-container").find(".traffic-instance")
          , $travelFixed = $("#travel-fixed")
          , $travelFixedItems = $travelFixed.find("li")
          , $calendarArea = $("#calendar-area");
        (function() {
            $trafficTypeCollection.eq(0).addClass("active");
            $trafficContainerCollection.eq(0).show();
            $navigateLinkCollection.eq(0).addClass("active");
            if ($travelFixed.length) {
                $travelFixedItems.eq(0).addClass("active");
            }
            $(".product-overview-protect").height($(".product-overview").height());
        }
        )();
        (function() {
            var $slidesListContainer = $("#overview-slide-show");
            if (!$slidesListContainer.find("li").length) {
                return;
            }
            $slidesListContainer.PikaChoose({
                carousel: true,
                autoPlay: false,
                showCaption: false
            });
        }
        )();
        (function() {
            var $priceExplain = $("#product-price-explain")
              , $priceViewMore = $("#price-view-more")
              , $priceViewMoreIcon = $("#price-view-more-icon");
            $(".overview-description").find(".tagsback").each(function() {
                $(this).poptip({
                    place: 6
                });
            }
            );
            $priceExplain.poptip({
                place: 7
            });
            $priceViewMore.poptip({
                place: 10
            });
            $('.js_tips').poptip({
                place: 6
            });
            $('.fc-tip').poptip({
                offsetX: -24
            });
            $priceViewMore.bind({
                mouseenter: function(e) {
                    $priceViewMoreIcon.removeClass("price-view-more-out");
                    return $priceViewMoreIcon.addClass("price-view-more-over");
                },
                mouseleave: function(e) {
                    $priceViewMoreIcon.removeClass("price-view-more-over");
                    return $priceViewMoreIcon.addClass("price-view-more-out");
                }
            });
        }
        )();
        (function() {
            $navigateLinkCollection.bind("click", function(e) {
                e.preventDefault();
                var currentTarget = $(e.currentTarget)
                  , flag = currentTarget.attr("data-flag")
                  , dest = $("#" + flag);
                if (!dest.length) {
                    return;
                }
                var destTopOffset = dest.offset().top;
                $win.scrollTop((destTopOffset - navBarHeight));
            }
            );
        }
        )();
        (function() {
            var automaticHeight = function() {
                var $trafficRight = $(".container .right");
                $trafficRight.each(function() {
                    var $prev = $(this).prev();
                    var prevHeight = $prev.actual("height");
                    $(this).css({
                        "height": prevHeight + "px",
                        "line-height": prevHeight + "px"
                    });
                }
                );
            }
            automaticHeight();
            $trafficType.each(function() {
                $(this).find('li').bind("click", function(e) {
                    var $currentTarget = $(e.currentTarget)
                      , dest = $currentTarget.data("traffic");
                    $(this).addClass('active').siblings().removeClass("active");
                    $("#" + dest + "-container").show().siblings().hide();
                    automaticHeight();
                }
                );
            }
            );
        }
        )();
        (function() {}
        )();
        (function() {
            var $navHeightHolder = $("#nav-height-holder"), navHeightHolderHeight = $navHeightHolder.height(), $productPreorder = $("#product-preorder"), $preorderAdjust = $("#preorder-adjust"), $preorderHeightHolder = $("#preorder-height-holder"), productContentOffset = {}, travelDaysOffset = {}, travelStart, adjustHeight, preorderHolderOffset, travelEnd, productTravelHeight, navTopOffset;
            var docHeightCallBack = function() {
                var productTravelHeight = $("#product-travel").height();
                navTopOffset = $navHeightHolder.offset().top;
                $navigateLinkCollection.each(function() {
                    var selectorId = $(this).attr("data-flag")
                      , $detailItem = $("#" + selectorId);
                    if ($detailItem.length > 0) {
                        productContentOffset[selectorId] = $detailItem.offset().top;
                    }
                }
                );
                if ($travelFixed.length) {
                    travelStart = $travelFixed.offset().top - 50;
                    travelEnd = travelStart + productTravelHeight - $travelFixed.height();
                    $travelFixedItems.each(function() {
                        var selectorId = $(this).attr("data-flag")
                          , $travelItem = $("#" + selectorId);
                        if ($detailItem.length > 0) {
                            travelDaysOffset[selectorId] = $travelItem.offset().top;
                        }
                    }
                    );
                }
                adjustHeight = $preorderAdjust.height()
                if (adjustHeight) {
                    preorderHolderOffset = $preorderHeightHolder.offset().top;
                }
            }
            util.checkeDocHeight(docHeightCallBack);
            docHeightCallBack();
            var scrollCallBack = function() {
                var currentWinTopOffset = $win.scrollTop();
                if (currentWinTopOffset - navTopOffset >= 0) {
                    $navigateHeader.addClass("navigate-fixed");
                } else {
                    $navigateHeader.removeClass("navigate-fixed");
                }
                for (var i in productContentOffset) {
                    if (currentWinTopOffset + navHeightHolderHeight >= productContentOffset[i]) {
                        $navigateLinkCollection.removeClass("active color-style2");
                        $navigateList.find('[data-flag="' + i + '"]').addClass("active color-style2");
                    }
                }
                if ($travelFixed.length) {
                    if (currentWinTopOffset >= travelStart && currentWinTopOffset <= travelEnd) {
                        $travelFixed.addClass("travel-nav-fixed");
                    } else {
                        $travelFixed.removeClass("travel-nav-fixed");
                    }
                    for (var i in travelDaysOffset) {
                        if (currentWinTopOffset >= (travelDaysOffset[i] - navBarHeight)) {
                            $travelFixedItems.removeClass("active");
                            $travelFixed.find('[data-flag="' + i + '"]').addClass("active");
                        }
                    }
                }
                if (adjustHeight) {
                    if (currentWinTopOffset >= preorderHolderOffset && currentWinTopOffset <= (preorderHolderOffset + adjustHeight)) {
                        $productPreorder.addClass("navigate-fixed");
                    } else {
                        $productPreorder.removeClass("navigate-fixed");
                    }
                }
            }
            scrollCallBack();
            $win.scroll(scrollCallBack);
        }
        )();
        var PreorderView = Backbone.Marionette.ItemView.extend({
            events: {
                "click #trip-time": "showDatapicker",
                "click #preorder-confirm-button": "preorderStart"
            },
            initialize: function(options) {
                _.extend(this, options);
                this.selectStyle();
                if (window.lineDetail.notSell == 'Y') {
                    $('#preorder-confirm-button').attr('class', 'btn_stop');
                }
            },
            dateSelected: function(data) {
                var $button = this.$el.find("#preorder-confirm-button");
                $button.html("立即预订");
                $button.attr("data-lock", true);
                $('.product-detail-booking').html("立即预订");
                $("#product-preorder").css({
                    "border-bottom": "1px solid #FFB346"
                });
                $("#preorder-start-time").val(data.date);
                window.lineDetail.javaCallback.dateSelected(e, data.date);
            },
            selectStyle: function() {
                pandora.selectModel({
                    autoWidth: false,
                    selectElement: this.$el.find(".adult-count")
                });
                pandora.selectModel({
                    autoWidth: false,
                    selectElement: this.$el.find(".children-count")
                });
                pandora.selectModel({
                    autoWidth: false,
                    selectElement: this.$el.find("#preorder-quantity")
                });
                pandora.selectModel({
                    autoWidth: false,
                    selectElement: this.$el.find("#playtime")
                });
            },
            preorderStart: function(e) {
                e.stopPropagation();
                if ($('#preorder-confirm-button').hasClass('btn_stop')) {
                    return;
                }
                var $currentTarget = $(e.currentTarget);
                if ($currentTarget.attr("data-disable")) {
                    return;
                }
                if ($currentTarget.attr("data-lock")) {
                    window.lineDetail.javaCallback.submitData(e);
                    return;
                } else {
                    $('#playtime').prev().attr('class', 'selectbox active selectbox-active').find('.selectbox-drop').show();
                }
                if (!$calendarArea.is(":visible")) {
                    $calendarArea.show();
                    if ($calendarArea.find('.calendar').length == 0) {
                        $('#preorder-start-time').addClass('preorder_time_loading');
                    } else {
                        $('#preorder-start-time').removeClass('preorder_time_loading');
                    }
                }
            },
            showDatapicker: function(e) {
                $calendarArea.show();
                if ($calendarArea.find('.calendar').length == 0) {
                    $('#preorder-start-time').addClass('preorder_time_loading');
                } else {
                    $('#preorder-start-time').removeClass('preorder_time_loading');
                }
            }
        });
        $calendarArea.bind("click", function(e) {
            e.stopPropagation();
        }
        );
        
        new PreorderView({
            el: "#product-preorder"
        });
        var eventUtil = {
            toggleDetail: function(e) {
                var $currentTarget = $(e.currentTarget)
                  , $arrow = $currentTarget.find("i")
                  , $detail = $currentTarget.parents(".adjust-product-item").find(".adjust-product-item-detail");
                if (!$arrow.length) {
                    return;
                }
                if ($arrow.hasClass("arrow-up")) {
                    $arrow.attr("class", "arrow");
                    $detail.hide();
                } else {
                    $arrow.addClass("arrow-up");
                    $detail.show();
                }
            },
            collapseDetail: function(e) {
                var $currentTarget = $(e.currentTarget)
                  , $dist = $currentTarget.parents(".adjust-product-item-detail")
                  , $arrow = $dist.parents(".adjust-product-item").find(".toggle-detail .arrow");
                $dist.hide();
                $arrow.attr("class", "arrow");
            },
            doSelectAction: function(e) {
                e.stopPropagation();
                var $currentTarget = $(e.currentTarget)
                  , $currentItem = $currentTarget.parents(".adjust-product-item")
                  , $target = $currentTarget.parents(".detail").find(".default")
                  , targetHTML = $target.html()
                  , $other = $currentTarget.parents(".detail");
                $other.find(".status").each(function() {
                    $(this).html('<button class="btn btn-mini do-select-action">选择</button>');
                }
                );
                $currentItem.find(".status").html('<i class="product-item-checked-icon"></i>');
                if ($currentItem.data("type") === "package") {
                    window.lineDetail.javaCallback.packageDoSelectAction(e, $currentItem);
                } else {
                    window.lineDetail.javaCallback.doSelectAction(e, $currentItem);
                }
            },
            replaceAction: function(e) {
                e.preventDefault();
                var $e = $(e.currentTarget);
                if ($e.data("toggle-text") === "insurance") {
                    window.lineDetail.javaCallback.insuranceReplaceCallback(e);
                    return;
                }
                window.lineDetail.javaCallback.replaceCallback(e);
            },
            upgradeOperator: function(e) {
                var $currentTarget = $(e.currentTarget)
                  , $status = $currentTarget.parent()
                  , $operatorCollection = $currentTarget.parents(".detail-item").find(".product-upgrade-operator")
                  , $infoNode = $currentTarget.parents(".adjust-product-item")
                  , type = $infoNode.data("type")
                  , id = $infoNode.data("id")
                  , quantity = $infoNode.find(".optional-change-quantity").val()
                  , price = $infoNode.data("price")
                  , itemId = $infoNode.data("item-id")
                  , visitTime = $infoNode.find(".change-date").val()
                  , multipleSelect = $currentTarget.data("multiple-select");
                if (!multipleSelect) {
                    $operatorCollection.each(function() {
                        var $current = $(this);
                        if (this === $currentTarget[0]) {
                            return;
                        }
                        $current.html('<i class="product-item-checked-icon"></i>');
                    }
                    );
                }
                if ($currentTarget.find("i").length) {
                    $currentTarget.html('<span>取消</span>');
                } else {
                    $currentTarget.html('<i class="product-item-checked-icon"></i>');
                }
                window.lineDetail.javaCallback.checkCallback(e);
            },
            changeEvent: function(e) {
               
            },
            selectUpgradeAction: function(e) {
                window.lineDetail.javaCallback.selectUpgradeAction(e);
                var destHTML = '<i class="product-item-checked-icon"></i><a class="abort-upgrade-action">取消</a>';
                var $e = $(e.currentTarget);
                var $container = $e.parents(".upgrade-item-status");
                var collect = $e.parents(".upgrade-other").find(".upgrade-item-status");
                collect.each(function() {
                    $(this).html('<button class="btn btn-mini select-upgrade-action">选择</button>');
                }
                );
                $container.html(destHTML);
            },
            abortUpgradeAction: function(e) {
                window.lineDetail.javaCallback.abortUpgradeAction(e);
                var destHTML = '<button class="btn btn-mini select-upgrade-action">选择</button>';
                var $e = $(e.currentTarget);
                var $container = $e.parents(".upgrade-item-status");
                $container.html(destHTML);
            }
        };
        var PreorderAdjust = Backbone.Marionette.ItemView.extend({
            initialize: function(options) {
                _.extend(this, options);
            },
            events: {
                "change .default select.change-quantity": "changeQuantity",
                "change .optional-change-quantity": "changeQuantity",
                "change .addtion-change-quantity": "changeAddtionQuantity",
                "change .default select.change-date": "changeDate",
                "change #adjust-optional select.change-date": "changeDate",
                "click .do-select-action": "doSelectAction",
                "click .reselect-date": "reselectDate",
                "click .show-more-date": "showMoreDate",
                "click .select-upgrade-action": "selectUpgradeAction",
                "click .abort-upgrade-action": "abortUpgradeAction"
            },
            doSelectAction: function(e) {
                eventUtil.doSelectAction(e);
            },
            reselectDate: function(e) {
                var $e = $(e.currentTarget);
                var $preorderStartTime = $("#preorder-start-time");
                $preorderStartTime.val($e.data("date"));
                window.lineDetail.javaCallback.dateSelected(e, data.date);
            },
            showMoreDate: function(e) {
                e.stopPropagation();
                $calendarArea.show();
                if ($calendarArea.find('.calendar').length == 0) {
                    $('#preorder-start-time').addClass('preorder_time_loading');
                } else {
                    $('#preorder-start-time').removeClass('preorder_time_loading');
                }
            },
            changeAddtionQuantity: function(e) {
                var $current = $(e.currentTarget);
                if (parseInt($current.val())) {
                    $current.parents(".adjust-product-item").find(".product-upgrade-operator").html('<i class="product-item-checked-icon"></i>');
                } else {
                    $current.parents(".adjust-product-item").find(".product-upgrade-operator").html('');
                }
            },
            changeQuantity: function(e) {
                var $currentTarget = $(e.currentTarget)
                  , $infoNode = $currentTarget.parents(".adjust-product-item");
                productType = $infoNode.data("type"),
                id = $infoNode.data("id"),
                itemId = $infoNode.data("item-id"),
                price = $infoNode.data("price"),
                quantity = parseInt($currentTarget.val());
                $infoNode.find(".price span").html(price * quantity);
            },
            changeDate: function(e) {},
            selectUpgradeAction: function(e) {
                e.preventDefault();
                e.stopPropagation();
                eventUtil.selectUpgradeAction(e);
            },
            abortUpgradeAction: function(e) {
                e.preventDefault();
                e.stopPropagation();
                eventUtil.abortUpgradeAction(e);
            }
        });
        var preorderAdjust = new PreorderAdjust({
            el: "#preorder-adjust"
        });
        (function() {
            $(".travel-fixed-item").click(function(e) {
                var $current = $(e.currentTarget);
                var flag = $current.data("flag");
                var destination = $("#" + flag)[0].offsetTop;
                $win.scrollTop(destination - navBarHeight);
                $(".travel-fixed-item").each(function() {
                    $(this).removeClass("active");
                }
                );
                $current.addClass("active");
            }
            );
        }
        )();
    }
    ;
    $(readyCallBack);
}
)();
function yudingStop() {
    $('#preorder-confirm-button').html("立即预订");
    $('#preorder-confirm-button').removeAttr('data-lock');
}
function winLoading(data, txt) {
    if (data == true && $('.windowBg').length == 0) {
        $('body').append('<div class="windowBg" style=" position:absolute; top:0; left:0; width:100%; background:#999; filter:alpha(opacity=50); -moz-opacity:0.5; -khtml-opacity:0.5; opacity:0.5; z-index:998;"></div><div class="winloading" style=" width:300px; height:50px; padding:26px 0; text-align:center; line-height:52px; font-size:14px; color:#666; background:#fff; border:#999 solid 1px; z-index:999; position:fixed; top:50%; margin-top:-50px; left:50%; margin-left:-150px;"><img style=" vertical-align:middle;" src="http://pic.lvmama.com/img/new_v/ui_scrollLoading/loadingGIF46px.gif" width="46" height="46" />　' + txt + '</div>');
        var height_w = $(document).height();
        $('.windowBg').css({
            'height': height_w
        });
    } else {
        $('.windowBg,.winloading').remove();
    }
}
$(function() {
    $('.btn_cw').live('click', function() {
        if (!$(this).hasClass('btn_up')) {
            $(this).addClass('btn_up').parents('tr').nextAll().show();
        } else {
            $(this).removeClass('btn_up').parents('tr').nextAll().hide();
        }
    }
    );
    $('.js_fancheng').live('click', function() {
        $('.plane_list_fan').show();
    }
    );
    $('.plane_type').hover(function() {
        var thisL = $(this).offset().left - 20
          , thisT = $(this).offset().top + 20
          , tanBox = $('.plane_type_box')
          , tdHtml = '';
        tanBox.show().css({
            'left': thisL,
            'top': thisT
        });
        for (var i = 0; i < tanBox.find('tr:first').find('th').length; i++) {
            tdHtml += '<td>' + $(this).attr('table_td' + (i + 1)) + '</td>'
        }
        tanBox.find('tr').eq(1).html(tdHtml);
    }
    , function() {
        $('.plane_type_box').hide();
    }
    );
    $(".qidi_zhuan").poptip();
    $('.instance_tab li').click(function() {
        var num = $(this).index()
          , L = $(this).offset().left
          , pL = $(this).parent().offset().left
          , W = $(this).outerWidth()
          , jtL = L - pL + W / 2 - 10;
        $(this).addClass('active').siblings().removeClass('active');
        $('.instance_list li').eq(num).show().siblings().hide();
        $('.instance_list2_box').each(function() {
            $(this).find('.instance_list2').eq(num).show().siblings().hide();
        }
        );
        $('.instance_jt').css('left', jtL);
    }
    );
    $('.travel-fixed').each(function() {
        var This = $(this)
        setTimeout(function() {
            This.find('li').eq(0).addClass('active');
        }
        , 300)
    }
    )
    for (var i = 1; i <= $('.instance_tab li').length; i++) {
        $('#J_scrollnav' + i).scrollNav({
            thisName: 'active',
            difference: 84
        });
    }
    $('.crumbs-list').hover(function() {
        $(this).addClass('crumbs-down');
    }
    , function() {
        $(this).removeClass('crumbs-down')
    }
    );
}
);
(function($) {
    $.scrollNav = {
        init: function(data) {
            this.fangfa(data);
        },
        fangfa: function(data) {
            var This = data.obj;
            var that = this;
            var Li = $(This).find('li');
            var Liname = data.thisName;
            var run = data.runName;
            var arrT = [];
            var ie6 = !-[1, ] && !window.XMLHttpRequest;
            var timer = null ;
            if (!ie6) {
                for (var i = 0; i < Li.length; i++) {
                    var thisId = Li.eq(i).attr('data-flag');
                    if ($('#' + thisId).length == 1) {
                        var T = $('#' + thisId).offset().top - data.difference;
                    } else {
                        var T = 9999999;
                    }
                    arrT.push(T);
                }
                $(window).scroll(function() {
                    clearTimeout(timer);
                    timer = setTimeout(function() {
                        scrollNow();
                    }
                    , 10)
                }
                );
                function scrollNow() {
                    var _scrollTop = $(document).scrollTop();
                    var lastH = $('#' + Li.last().attr('data-flag')).height();
                    arrT = [];
                    for (var i = 0; i < Li.length; i++) {
                        var thisId = Li.eq(i).attr('data-flag');
                        if ($('#' + thisId).length == 1) {
                            var T = $('#' + thisId).offset().top - data.difference;
                        } else {
                            var T = 9999999;
                        }
                        arrT.push(T);
                    }
                    for (var j = 0; j < arrT.length; j++) {
                        var _top = arrT[j];
                        if (_scrollTop >= _top) {
                            if (_scrollTop >= arrT[arrT.length - 1] + lastH) {
                                Li.removeClass(Liname);
                            } else {
                                Li.eq(j).addClass(Liname).siblings().removeClass(Liname);
                            }
                        }
                    }
                    ;var runSr = run.parent().offset().top;
                    if (_scrollTop > runSr && _scrollTop < runSr + run.parent().height() - $(This).height()) {
                        $(This).parent().css({
                            'position': 'fixed',
                            'top': 60,
                            'z-index': 100,
                            'width': 100
                        });
                    } else if (_scrollTop < run.parent().offset().top) {
                        Li.eq(0).addClass(Liname).siblings().removeClass(Liname);
                        run.attr({
                            'style': ''
                        });
                    } else {
                        run.attr({
                            'style': ''
                        });
                    }
                    ;if (data.maxTrigger == false) {
                        if (_scrollTop >= arrT[arrT.length - 1] + lastH) {
                            if (data.trigger.length > 1) {
                                data.trigger[0]();
                            } else {
                                data.trigger();
                            }
                        } else {
                            if (data.trigger.length > 1) {
                                data.trigger[1]();
                            }
                        }
                    } else {
                        if (_scrollTop >= arrT[data.triggerNum]) {
                            if (data.trigger.length > 1) {
                                data.trigger[0]();
                            } else {
                                data.trigger();
                            }
                        } else {
                            if (data.trigger.length > 1) {
                                data.trigger[1]();
                            }
                        }
                    }
                }
                ;scrollNow();
                Li.click(function() {
                    var navThis = this
                      , index = $(this).index();
                    arrT = [];
                    for (var i = 0; i < Li.length; i++) {
                        var thisId = Li.eq(i).attr('data-flag');
                        if ($('#' + thisId).length == 1) {
                            var T = $('#' + thisId).offset().top - data.difference;
                        } else {
                            var T = 9999999;
                        }
                        arrT.push(T);
                    }
                    $('body,html').animate({
                        'scrollTop': arrT[index] + 1
                    }, data.runTime, function() {
                        setTimeout(function() {
                            $(navThis).addClass(Liname).siblings().removeClass(Liname);
                        }
                        , 50)
                    }
                    );
                }
                )
            }
            ;
        },
        trigger: function() {}
    };
    $.fn.scrollNav = function(options) {
        var data = {
            obj: this,
            thisName: 'active',
            runName: $(this).parent(),
            difference: $(this).parent().outerHeight(),
            triggerNum: 0,
            runTime: 0,
            maxTrigger: true,
            trigger: function() {}
        };
        $.extend(true, data, options || {});
        $.scrollNav.init(data);
    }
    ;
}
)(jQuery);
(function() {
    $('.tripTab span').each(function(e) {
        var $_this = $(this)
        $_this.click(function() {
            $_this.addClass('active').siblings('span').removeClass('active');
            $('.tripListBox>div').eq(e).show().siblings().hide();
        }
        );
    }
    );
}
)();
(function() {
    var $body = $('body')
      , $selectSimu = $('.selectSimu')
      , $opt = $('.selectSimu-opt')
      , $ipt = $('.selectSimu .select-arrow')
      , $selectValue = $('.select-value')
      , $con = $('.selectSimu-optCon');
    $('.selectSimu-optTab>span').click(function(e) {
        e.stopPropagation();
        var $me = $(this);
        $me.addClass('active').siblings().removeClass('active');
        $con.eq($me.index()).addClass('active').siblings('.selectSimu-optCon').removeClass('active');
    }
    );
    $ipt.click(function(e) {
        if ($opt.is(":hidden")) {
            $opt.show();
            $selectSimu.addClass('active');
        } else {
            $opt.hide();
            $selectSimu.removeClass('active');
        }
        e.stopPropagation();
    }
    );
    $opt.click(function(e) {
        e.stopPropagation();
        var target = e.target;
        if (target.nodeName == 'A') {
            $selectValue.html($(target).text()).attr('data-cityid', $(target).attr('data-cityid'));
            $opt.hide();
            $selectSimu.removeClass('active');
        }
    }
    );
    $body.click(function() {
        if (!$opt.is(":visible"))
            return;
        $opt.hide();
        $selectSimu.removeClass('active');
    }
    );
    $('.js_xc_tab li').click(function() {
        var num = $(this).index();
        $(this).addClass('active').siblings().removeClass('active');
    }
    );
}
)(jQuery);
$(function() {
    var $document = $(document);
    var $changeDialog = $(".ldt_change");
    pandora.selectModel({
        'autoWidth': false,
        'selectElement': $('.ldt_t_number')
    });
    pandora.selectModel({
        'autoWidth': false,
        'selectElement': $('.ldt_tcicit_select')
    });
    $document.on("click", ".ldt_nav_tabs>li", tabSwitchHandler);
    function tabSwitchHandler() {
        var $this = $(this);
        var $tabs = $this.parents(".ldt_nav_tabs").eq(0);
        var $tab = $tabs.find("li");
        var $parent = $tabs.parent();
        var $content = $parent.find(".ldt_tab_content");
        var $pane = $content.find(".ldt_tab_pane");
        var index = $tab.index($this);
        $this.addClass("ldt_tab_active").siblings().removeClass("ldt_tab_active");
        $pane.eq(index).addClass("ldt_tab_active").siblings().removeClass("ldt_tab_active");
    }
    $document.on("click", ".ldt_ccs_tabs>li", ccsSwitchHandler);
    function ccsSwitchHandler() {
        var $this = $(this);
        var $tabs = $this.parents(".ldt_ccs_tabs").eq(0);
        var $tab = $tabs.find("li");
        var $parent = $tabs.parent();
        var $content = $parent.find(".ldt_ccs_content");
        var $pane = $content.find(".ldt_ccs_pane");
        var index = $tab.index($this);
        $this.addClass("ldt_ccs_active").siblings().removeClass("ldt_ccs_active");
        $pane.eq(index).addClass("ldt_ccs_active").siblings().removeClass("ldt_ccs_active");
    }
    $document.on("click", ".JS_css_secrch_more_btn", function() {
        var $this = $(this);
        if ($this.html().indexOf("arrow_up") == -1) {
            $this.html('收起<i class="arrow_up"></i>').siblings('.ldt_ccs_search_theme_list').addClass('ldt_ccs_search_more');
        } else {
            $this.html('更多<i class="arrow"></i>').siblings('.ldt_ccs_search_theme_list').removeClass('ldt_ccs_search_more');
        }
    }
    );
    $document.on("click", ".ldt_crr_btn", function() {
        var $this = $(this);
        if ($this.is(".ldt_crr_btn_disabled")) {
            return false;
        }
        if ($this.parents(".ldt_cr_list").length) {
            $this.parents(".ldt_cr_list").addClass("ldt_cr_list_active").siblings().removeClass("ldt_cr_list_active");
        } else {
            $this.parents(".ldt_cce_list").addClass("ldt_cce_list_active").siblings().removeClass("ldt_cce_list_active");
        }
    }
    );
    $(".ldt_tagtips").poptip({
        skin: "ldt",
        offsetX: -25
    });
    $('#product-recommend').on('click', '.product-line-tab li', function() {
        $productnum = $(this).index();
        $(this).addClass('active').siblings().removeClass('active');
        $(this).parents('.product-line-tab').siblings('.product-line-list').eq($productnum).show().siblings('.product-line-list').hide();
    }
    );
    var $titleTab = $('.title-tab li');
    $titleTab.click(function() {
        $titlenum = $(this).index();
        $(this).addClass('active').siblings().removeClass('active');
        $(this).parent().parent().siblings('.product-content').eq($titlenum).show().siblings('.product-content').hide();
    }
    );
    $('.product-line-list li').hover(function() {
        $(this).find('.product-line-bg').show();
    }
    , function() {
        $(this).find('.product-line-bg').hide();
    }
    );
    $(".tags101").poptip();
}
);
$(".product_top_img").bind("click", function(e) {
    e = e || window.event;
    var target = e.target || e.srcElement
      , $target = $(target);
    if ($target.hasClass("prev") && !$target.hasClass("disable") || $target.hasClass("btn_l") && !$target.hasClass("disable"))
        imageScroll("up");
    else if ($target.hasClass("next") && !$target.hasClass("disable") || $target.hasClass("btn_r") && !$target.hasClass("disable"))
        imageScroll("down");
}
);
$(".scrollImg_wrap li").bind("click", function() {
    $(this).addClass("active").siblings().removeClass("active");
    var $li = $(".scrollImg_wrap").find("li.active")
      , currentMargin = parseInt($(".scrollImg_wrap").find("ul").css("margin-top").replace("px", ""));
    if ($li.prev().size() == 0)
        $(".scrollBtn").find(".prev").addClass("disable");
    else
        $(".scrollBtn").find(".prev").removeClass("disable");
    if ($li.next().size() == 0)
        $(".scrollBtn").find(".next").addClass("disable");
    else
        $(".scrollBtn").find(".next").removeClass("disable");
    var src = $(this).attr("data-src");
    $(".focusImg").find("img").attr("src", src);
}
);
function imageScroll(direct) {
    var $wrap = $(".scrollImg_wrap")
      , $btnWrap = $wrap.siblings(".scrollBtn")
      , $ul = $wrap.find("ul")
      , currentMargin = parseInt($ul.css("margin-top").replace("px", ""))
      , $activeLi = $ul.find("li.active")
      , scrollHeight = $ul.find("li:eq(0)").outerHeight(true);
    if ($ul.is(":animated"))
        return;
    if (direct == "up") {
        if (currentMargin < -5) {
            $activeLi.removeClass("active").prev().addClass("active");
            $ul.animate({
                "margin-top": "+=" + scrollHeight
            }, 500, function() {
                $btnWrap.find(".next").removeClass("disable");
                currentMargin = parseInt($ul.css("margin-top").replace("px", ""));
                if (currentMargin >= -5 && $ul.find("li.active").prev().size() == 0)
                    $btnWrap.find(".prev").addClass("disable");
                $btnWrap.find(".next").removeClass("disable");
            }
            );
        } else if (currentMargin >= -5 && $activeLi.prev().size() > 0) {
            $activeLi.removeClass("active").prev().addClass("active");
            if ($ul.find("li.active").prev().size() == 0) {
                $btnWrap.find(".prev").addClass("disable");
                $btnWrap.find(".next").removeClass("disable");
            }
        }
    } else {
        var maxRange = ($ul.find("li").size() - Math.ceil($wrap.height() / scrollHeight)) * scrollHeight - 5;
        if (currentMargin <= maxRange * -1) {
            if ($activeLi.next().size() > 0) {
                $activeLi.removeClass("active").next().addClass("active");
                if ($ul.find("li.active").next().size() == 0) {
                    $btnWrap.find(".next").addClass("disable");
                    $btnWrap.find(".prev").removeClass("disable");
                }
            }
            var src = $ul.find("li.active").attr("data-src");
            $(".focusImg").find("img").attr("src", src);
            return;
        }
        $activeLi.removeClass("active").next().addClass("active");
        $ul.animate({
            "margin-top": "-=" + scrollHeight
        }, 500, function() {
            $btnWrap.find(".prev").removeClass("disable");
            currentMargin = parseInt($ul.css("margin-top").replace("px", ""));
            if (currentMargin <= maxRange * -1 && $ul.find("li.active").next().size() == 0)
                $btnWrap.find(".next").addClass("disable");
            $btnWrap.find(".prev").removeClass("disable");
        }
        );
    }
    var src = $ul.find("li.active").attr("data-src");
    $(".focusImg").find("img").attr("src", src);
}
(function($) {
    var defaults = {
        animateSpeed: 800,
        isAutoRun: true,
        autoSpeed: 5000
    };
    $.yinSlider = function(options) {
        var _options = $.extend(defaults, options);
        var PRE_INDEX = 0;
        var $sliderDiv = _options.sliderDiv;
        var $picBox = _options.picBox;
        var $leftBtn = _options.leftBtn;
        var $rightBtn = _options.rightBtn;
        var $btn = _options.btn;
        var $picList = $picBox.find("li");
        $picList.css({
            "z-index": "0",
            "opacity": "0"
        });
        $picList.eq(0).css({
            "z-index": "1",
            "opacity": "1"
        });
        var picAmount = $picList.length;
        $leftBtn.on("click", function() {
            showPic((PRE_INDEX + picAmount - 1) % picAmount);
        }
        );
        $rightBtn.on("click", function() {
            showPic((PRE_INDEX + 1) % picAmount);
        }
        );
        $sliderDiv.hover(function() {
            $btn.show();
        }
        , function() {
            $btn.hide();
        }
        );
        function showPic(index) {
            $picList.stop(true, true).eq(PRE_INDEX).css("z-index", "0").animate({
                opacity: "0"
            }, _options.animateSpeed);
            $picList.eq(index).css("z-index", "1").animate({
                opacity: "1"
            }, _options.animateSpeed);
            PRE_INDEX = index;
        }
    }
}
)(jQuery);
$(function() {
    var $dialogOverlay = $('.yin-dialog-overlay')
      , $dialog = $('.yin-dialog');
    $('.ph_icon_close_dialog').on("click", function() {
        $dialogOverlay.stop(true, true).fadeOut();
        $dialog.stop(true, true).fadeOut();
        $('body').removeAttr('style');
    }
    );
    var $document = $(document);
    $document.on("click", ".yhir-room-name a, .yhir-collapse", function() {
        $(this).parents(".yhir-room").toggleClass("yhir-open-room");
    }
    );
    $document.on("click", ".yhir-open-room-list span", function() {
        var $thisList = $(this).parent();
        var $listBox = $thisList.parent();
        if ($thisList.hasClass("yhir-open-all-rooms")) {
            $listBox.find(".yhir-room:gt(2)").hide();
            $listBox.find(".yhir-room").removeClass("yhir-open-room");
            $thisList.removeClass("yhir-open-all-rooms");
            $thisList.html('<span>展开其他房型<i class="arrow"></i></span>');
        } else {
            $listBox.find(".yhir-room").show();
            $thisList.addClass("yhir-open-all-rooms");
            $thisList.html('<span>收起其他房型<i class="arrow"></i></span>');
        }
    }
    );
}
);
function showYinDialog(isTicketDialog, isCommented, isMultipleImages) {
    var $dialogOverlay = $('.yin-dialog-overlay')
      , $dialog = $('.yin-dialog');
    $dialog.addClass("yin-dialog-loading");
    if (isTicketDialog) {
        $dialog.addClass("yin-dialog-for-ticket");
    } else {
        $dialog.removeClass("yin-dialog-for-ticket");
    }
    if (isCommented) {
        $dialog.removeClass("yin-dialog-without-comments");
    } else {
        $dialog.addClass("yin-dialog-without-comments");
    }
    if (isMultipleImages) {
        $dialog.addClass("yin-dialog-with-more-pics");
        $.yinSlider({
            sliderDiv: $(".yin-dialog-slider"),
            picBox: $(".slider-pic-box"),
            leftBtn: $(".slider-btn-left"),
            rightBtn: $(".slider-btn-right"),
            btn: $(".slider-btn")
        });
    } else {
        $dialog.removeClass("yin-dialog-with-more-pics");
    }
    $dialogOverlay.fadeIn(300);
    $dialog.fadeIn(300);
    $('body').attr('style', 'overflow:none;+overflow:hidden;_overflow:hidden;height=100%;overflow:hidden;+overflow:none;_overflow:none;padding:0 17px 0 0');
}
function removeYinDialogLoading() {
    $dialog = $('.yin-dialog');
    $dialog.removeClass("yin-dialog-loading");
}
$(function() {
    var $document = $(document);
    $document.on("click", ".JS_group_mail", function() {
        $(".ncxc_fade").show();
        $(".ncxc_popUp").show();
    }
    );
    ncsetFade($('.ncxc_fade'));
    function ncsetFade(elem) {
        var winWid = $(document).width();
        var winHei = $(document).height();
        elem.css({
            width: winWid + 'px',
            height: winHei + 'px'
        });
    }
    $('.ncxc_popClose').click(function() {
        $(this).parents('.ncxc_popUp').hide();
        $('.ncxc_fade').hide();
    }
    );
}
);
$(function() {
    var $document = $(document);
    $document.on("click", ".preorder-start-time-select-div", function() {
        var $this = $(this);
        $this.addClass("active");
    }
    );
    $document.on("click", "body", function(e) {
        var $target = $(e.target);
        var $div = $target.parents(".preorder-start-time-select-div");
        if ($target.parents(".preorder-start-time-select-div").length > 0) {
            var $li = $target.parents(".preorder-start-time-select-div ul li");
            if ($li.length > 0) {
                setLi($li);
            } else if ($target.is(".preorder-start-time-select-div ul li")) {
                setLi($target);
            }
        } else {
            $(".preorder-start-time-select-div").removeClass("active");
        }
        function setLi($li) {
            var $date = $li.find(".preorder-start-time-date").clone();
            var $adult = $li.find(".preorder-start-time-adult").clone();
            var $children = $li.find(".preorder-start-time-children").clone();
            var date = $date.html();
            var adult = $adult.html();
            var children = $children.html();
            var $selected = $div.find(".preorder-start-time-select-selected");
            $selected.removeClass("preorder-start-time-select-placeholder");
            $selected.empty();
            $selected.append($date);
            $selected.append($adult);
            $selected.append($children);
        }
    }
    );
    var $window = $(window);
    var $app = $(".app-float-flow");
    $window.on("scroll", function() {
        var height = $window.scrollTop();
        if (height > 220) {
            $app.css({
                "top": 0
            })
        } else {
            $app.css({
                "top": -height + 220
            })
        }
    }
    );
    $document.on("mouseenter", ".app-float-flow", function() {
        var $this = $(this);
        var $code = $this.find(".app-qr-code");
        $code.show().stop(true, true).animate({
            "width": 134
        });
        $this.find("em,b").show();
    }
    );
    $document.on("mouseleave", ".app-float-flow", function() {
        var $this = $(this);
        var $code = $this.find(".app-qr-code");
        $code.stop(true, true).animate({
            "width": 0
        }, function() {
            $code.hide();
            $this.find("em,b").hide();
        }
        );
    }
    );
    $document.on("click", ".JS_view_more_product_travel", function() {
        var top = $("#product-travel").offset().top;
        $('body,html').scrollTop(top - 50);
    }
    );
}
);
function showLoading() {
    $(".ft-overlay, .ft-dialog-loading").show();
}
function hideLoading() {
    $(".ft-overlay, .ft-dialog-loading").hide();
}
$(function() {
    function Showmore(e) {
        var $_this = $(this)
          , p = $_this.parent('dd').find('p:nth-child(n+' + e.data.i + ')');
        if ($_this.hasClass('open')) {
            p.hide();
            $_this.removeClass('open').html('展开<span></span>');
        } else {
            p.show();
            $_this.addClass('open').html('收起<span></span>');
        }
    }
    $('.JS_travelTime').on('click', {
        i: 3
    }, Showmore);
    $('.JS_showLine').on('click', {
        i: 6
    }, Showmore);
    $('.materialView').click(function() {
        var ulHeight = $(this).siblings('.materialContent').height()
        if (ulHeight == '88') {
            $(this).siblings('.materialContent').css({
                'height': 'auto'
            });
            $(this).html('收起<i class="materialDown"></i>')
        } else {
            $(this).siblings('.materialContent').css({
                'height': '88px'
            });
            $(this).html('查看更多<i class="materialUp"></i>');
        }
    }
    );
}
);
(function() {
    $('.booking_tips').click(function() {
        $('body,html').scrollTop($('.booking-way').offset().top - 50);
    }
    );
}
)();
