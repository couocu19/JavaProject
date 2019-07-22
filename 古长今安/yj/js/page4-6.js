var cutItm = 0;

function autoPlay() {
    cutItm++;
    if (cutItm > 5) {
        cutItm = 0;
    }
    $(".bd_c4l li").removeClass("bd_cutLi");
    $(".bd_c4l li").eq(cutItm).addClass("bd_cutLi");
    var leftVal = cutItm * 696;
    $(".bd_long").animate({ left: -leftVal }, 500);
}

var timeer = setInterval(autoPlay, 3000);
$(".bd_c4l,.bd_c4top").hover(function() { clearInterval(timeer) }, function() { timeer = setInterval(autoPlay, 3000); });

$(".bd_c4l li").click(function() {
    cutItm = $(".bd_c4l li").index(this);
    $(".bd_c4l li").removeClass("bd_cutLi");
    $(this).addClass("bd_cutLi");
    var leftVal = cutItm * 696;
    $(".bd_long").animate({ left: -leftVal }, 500);
});
$(".bd_lbtn").click(function() {
    cutItm--;
    if (cutItm < 0) {
        cutItm = 5;
    }
    $(".bd_c4l li").removeClass("bd_cutLi");
    $(".bd_c4l li").eq(cutItm).addClass("bd_cutLi");
    var leftVal = cutItm * 696;
    $(".bd_long").animate({ left: -leftVal }, 500);
});
$(".bd_rbtn").click(function() {
    cutItm++;
    if (cutItm > 5) {
        cutItm = 0;
    }
    $(".bd_c4l li").removeClass("bd_cutLi");
    $(".bd_c4l li").eq(cutItm).addClass("bd_cutLi");
    var leftVal = cutItm * 696;
    $(".bd_long").animate({ left: -leftVal }, 500);
});




(function($, window, undefined) {
    'use strict';
    // global
    var Modernizr = window.Modernizr;
    $.CBPQTRotator = function(options, element) {
        this.$el = $(element);
        this._init(options);
    };

    $.CBPQTRotator.defaults = {
        speed: 700,
        easing: 'ease',
        interval: 8000
    };

    $.CBPQTRotator.prototype = {
        _init: function(options) {

            this.options = $.extend(true, {}, $.CBPQTRotator.defaults, options);
            this._config();
            this.$items.eq(this.current).addClass('cbp-qtcurrent');
            if (this.support) {
                this._setTransition();
            }
            this._startRotator();

        },
        _config: function() {
            this.$items = this.$el.children('div.cbp-qtcontent');
            this.itemsCount = this.$items.length;
            this.current = 0;
            this.support = Modernizr.csstransitions;
            if (this.support) {
                this.$progress = $('<span class="cbp-qtprogress"></span>').appendTo(this.$el);
            }

        },
        _setTransition: function() {
            setTimeout($.proxy(function() {
                this.$items.css('transition', 'opacity ' + this.options.speed + 'ms ' + this.options.easing);
            }, this), 25);
        },
        _startRotator: function() {

            if (this.support) {
                this._startProgress();
            }

            setTimeout($.proxy(function() {
                if (this.support) {
                    this._resetProgress();
                }
                this._next();
                this._startRotator();
            }, this), this.options.interval);

        },
        _next: function() {

            this.$items.eq(this.current).removeClass('cbp-qtcurrent');
            this.current = this.current < this.itemsCount - 1 ? this.current + 1 : 0;
            this.$items.eq(this.current).addClass('cbp-qtcurrent');

        },
        _startProgress: function() {

            setTimeout($.proxy(function() {
                this.$progress.css({ transition: 'width ' + this.options.interval + 'ms linear', width: '100%' });
            }, this), 25);

        },
        _resetProgress: function() {
            this.$progress.css({ transition: 'none', width: '0%' });
        },
        destroy: function() {
            if (this.support) {
                this.$items.css('transition', 'none');
                this.$progress.remove();
            }
            this.$items.removeClass('cbp-qtcurrent').css({
                'position': 'relative',
                'z-index': 100,
                'pointer-events': 'auto',
                'opacity': 1
            });
        }
    };

    var logError = function(message) {
        if (window.console) {
            window.console.error(message);
        }
    };

    $.fn.cbpQTRotator = function(options) {
        if (typeof options === 'string') {
            var args = Array.prototype.slice.call(arguments, 1);
            this.each(function() {
                var instance = $.data(this, 'cbpQTRotator');
                if (!instance) {
                    logError("cannot call methods on cbpQTRotator prior to initialization; " +
                        "attempted to call method '" + options + "'");
                    return;
                }
                if (!$.isFunction(instance[options]) || options.charAt(0) === "_") {
                    logError("no such method '" + options + "' for cbpQTRotator instance");
                    return;
                }
                instance[options].apply(instance, args);
            });
        } else {
            this.each(function() {
                var instance = $.data(this, 'cbpQTRotator');
                if (instance) {
                    instance._init();
                } else {
                    instance = $.data(this, 'cbpQTRotator', new $.CBPQTRotator(options, this));
                }
            });
        }
        return this;
    };
})(jQuery, window);

function Ajax(object) {
    xhr = new XMLHttpRequest();
    xhr.withCredentials = true; //携带cookie
    var message = getParmer(object.data);
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            var status = xhr.status;
            if (status >= 200 && status < 300) {
                object.success(xhr);
            } else {
                object.fail(xhr.status);
            }
        }
    };

    if (object.type == 'get') {
        xhr.open("get", object.url + "?" + message, object.async);
        xhr.send(null);
    } else if (object.type == 'post') {
        xhr.open("post", object.url, object.async);
        if (object.token) {
            let token = sessionStorage.getItem('token');
            xhr.setRequestHeader('token', token);
        }
        if (object.contenttype == 'form') {
            xhr.setRequestHeader("Content-Type", "multipart/form-data");
        } else {
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        }
        xhr.send(message);
    }

    function getParmer(data) {
        var arr = [];
        for (var thing in data) {
            arr.push(encodeURIComponent(thing) + '=' + encodeURIComponent(data[thing]));
        }
        return arr.join('&');
    }
}
let ajaxflag = 0;
const submit = document.getElementsByClassName('submit')[0];
const wrongtips = document.getElementsByClassName('wrongtips')[0];
submit.addEventListener('click', function() {
    let mymsg = document.getElementsByClassName('mymsg')[0].value;
    if (ajaxflag == 1) {
        wrongtips.innerHTML = '不能多次发送';
        return;
    } else {
        ajaxflag = 1;
        Ajax({
            url: "http://132.232.169.227:3344/leavemsg", //请求地址
            type: 'post',
            contenttype: 'urlencode',
            data: { msg: mymsg },
            async: false, //是否异步
            success: function(xhr) {
                ajaxflag = 0;
                let res = JSON.parse(xhr.responseText);
                if (res.style != 0) {
                    wrongtips.innerHTML = res.msg;
                    setTimeout(function() {
                        wrongtips.innerHTML = '';
                    }, 1500)
                } else {
                    wrongtips.innerHTML = '留言成功';
                    setTimeout(function() {
                        wrongtips.innerHTML = '';
                    }, 1500)
                    getmsg();
                }
            },
            fail: function(err) {
                alert('通信失败');
            }
        })
    }
})
let liuyanban = document.getElementsByClassName('liuyanban')[0];
getmsg();

function getmsg() {
    if (ajaxflag == 1) {
        wrongtips.innerHTML = '不能多次发送';
        return;
    } else {
        ajaxflag = 1;
        Ajax({
            url: "http://132.232.169.227:3344/getinfo", //请求地址
            type: 'get',
            contenttype: 'urlencode',
            data: null,
            async: false, //是否异步
            success: function(xhr) {
                ajaxflag = 0;
                let res = JSON.parse(xhr.responseText);
                if (res.style != 0) {
                    wrongtips.innerHTML = res.msg;
                    setTimeout(function() {
                        wrongtips.innerHTML = '';
                    }, 1500)
                } else {
                    let arr = res.msg; //获取到的留言
                    let inner = '';
                    let picc;
                    for (let i = 0; i < arr.length; i++) {
                        picc = i % 3 + 1;
                        inner += '<div><img src = "./pic/' + picc + '.jpg" class = "liu-pic" style = "margin-top: 10px;" />' +
                            '<h3 class = "liu-name">留言</h3><p>' + arr[i].message + '</p></div>'
                    }
                    liuyanban.innerHTML = inner;
                }
            },
            fail: function(err) {
                alert('通信失败');
            }
        })
    }
}