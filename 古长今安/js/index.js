//第一页信息变换
let historyinfo = [{
        img: './pic/bianzhong.jpg',
        header: '编钟',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;古代打击乐器。编钟兴起于西周，盛于春秋战国直至秦汉。编钟的钟体小，音调就高，音量也小；钟体大，音调就低，音量也大。只有dou ruai mi so la 五个音。'
    },
    {
        img: './pic/qingtong1.jpeg',
        header: '早期蚕纹方鼎',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通高23厘米，口长18.3厘米，宽14.5厘米。腹部四周棱角与每面中各有一扉棱，大面上层铸4只“S”形蚕纹，云雷纹地，蚕纹下饰勾连纹，其余部分饰乳钉；小面上部施两蚕纹，下饰乳丁。四柱足上粗下细，饰兽面纹。'
    }, {
        img: './pic/qingtong2.jpg',
        header: '父辛爵',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通高22.3cm,腹深9.8cm,重1050g。西周穆王时期 温饮酒器 父辛为人名 爵为器名 该器宽流、长尾、深腹、圆底，下乘三刀状足。流饰垂冠凤纹，记木羊氏为父辛做器。'
    },
    {
        img: './pic/qingtong3.png',
        header: '双耳铜杯',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1965年出土于西安市长安区张家坡村西周墓地，通高14厘米，口径8.5厘米。直口，腰部微束，中有一道箍棱。两侧有对称的镂空云纹耳。置极繁于极简之中，具有独特的设计感。'
    },
    {
        img: './pic/renlongwenyubi.jpg',
        header: '人龙纹环',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人龙纹环为西周时期的玉器，直径12.5、孔径5.1、厚0.2厘米。圆形，中部有圆孔，背面光素无纹，正面雕刻两组人、龙合体共身图案，饰眼目纹、勾云纹和弧线纹等。'
    },
    {
        img: './pic/yuzupei.jpg',
        header: '玉组佩',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;玉组佩以镂雕绶带纹长方形玉饰系鎏金银链下挂5件玉坠而成，玉坠分别为摩羯、双鱼、双凤、双龙、鱼衔莲枝佩。龙、凤、鱼等吉祥题材的运用以及雕琢刻划中所表现出的写实风格，具有浓郁的中原文化气息，显示出辽地诸族文化的交流及玉器制作的发展水平。'
    },
    {
        img: './pic/yuzhang.jpg',
        header: '玉璋',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;玉璋是和玉圭相似，呈扁平长方体状，一端斜刃（也有叉形刃），另一端有穿孔。玉璋的形状，东汉许慎在《说文解字》中说：“半圭为璋。”'
    }, {
        img: './pic/yuhuang.jpg',
        header: '玉璜',
        info: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;玉璜是一种礼仪性的挂饰。每当进行宗教礼仪活动时，巫师就戴上它，它经常与玉管、玉串组合成一串精美的挂饰，显示出巫师神秘的身份。且每一个上都刻有或繁或简的神人兽面图象。'
    }
]
let firstpagebutton = document.getElementsByClassName('button-jittery')[0];
let portfolioitemimage = document.getElementsByClassName('portfolio-item__image');
let portfolioitemheader = document.getElementsByClassName('portfolio-item__header');
let portfolioitemlinks = document.getElementsByClassName('portfolio-item__links');
let portfolioitem = document.getElementsByClassName('portfolio-item');

function changeInfo() {
    var i = 0;
    firstpagebutton.addEventListener('click', function() {
        i += 4;
        console.log(i);
        if (i == 8) {
            i = 0;
            addinfo(i);
        } else {
            addinfo(i);
        }
    })
}

function addinfo(i) {

    setTimeout(function() {
            for (let j = 0; j < 4; j++) {
                if (j == 0) {
                    portfolioitem[0].style = 'margin-bottom: 70px;opacity:0;'
                } else {
                    portfolioitem[j].style = 'opacity:0;';
                }
            }
            setTimeout(function() {
                for (let k = 0; k < 4; k++) {
                    if (k == 0) {
                        portfolioitem[0].style = 'margin-bottom: 70px;opacity:1;'
                    } else {
                        portfolioitem[k].style = 'opacity:1;';
                    }
                }
            }, 500)
        }, 0)
        //图片
    portfolioitemimage[0].src = historyinfo[i].img;
    portfolioitemimage[1].src = historyinfo[i + 1].img;
    portfolioitemimage[2].src = historyinfo[i + 2].img;
    portfolioitemimage[3].src = historyinfo[i + 3].img;
    //标题
    portfolioitemheader[0].innerHTML = historyinfo[i].header;
    portfolioitemheader[1].innerHTML = historyinfo[i + 1].header;
    portfolioitemheader[2].innerHTML = historyinfo[i + 2].header;
    portfolioitemheader[3].innerHTML = historyinfo[i + 3].header;
    //详细
    portfolioitemlinks[0].innerHTML = historyinfo[i].info;
    portfolioitemlinks[1].innerHTML = historyinfo[i + 1].info;
    portfolioitemlinks[2].innerHTML = historyinfo[i + 2].info;
    portfolioitemlinks[3].innerHTML = historyinfo[i + 3].info;
}
changeInfo();
//第二页
let container = document.getElementsByClassName('imgcontainer')[0];
let imgs = document.getElementsByClassName('img');
let cards = document.getElementsByClassName('imgsdetils');
let imgsdetilsbox = document.getElementsByClassName('imgsdetilsbox')[0];
let imgflag = 0;
for (let i = 0; i < imgs.length; i++) {
    imgs[i].addEventListener('click', function() {
        imgs[imgflag].style = 'box-shadow:0 0 0;';
        imgs[i].style = 'box-shadow: 0 0 25px #fff inset;';
        if (imgflag != i) {
            imgsdetilsbox.classList.add('cardsmile');
            setTimeout(function() {
                imgsdetilsbox.classList.remove('cardsmile');
            }, 600);
            cards[imgflag].style = 'display:none;';
            cards[i].style = 'display:block;';
            imgsdetilsbox.classList.add('cardbig');
            setTimeout(function() {
                imgsdetilsbox.classList.remove('cardbig');
            }, 600);
            imgflag = i;
        } else {
            return;
        }
    });
}