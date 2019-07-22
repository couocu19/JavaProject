var swiper = new Swiper('.swiper-container', {
    direction: 'vertical',
    slidesPerView: 1,
    spaceBetween: 30,
    mousewheel: true,
    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },
    
    on:{
        slideChangeTransitionEnd:function(){
            setSwiper(this.activeIndex);
        },
        slideChange: function(){
           
        }
    }

});
function page1anmit(flag){
    let calligraphy = document.getElementsByClassName('calligraphy')[0];
    if(flag==1){
        calligraphy.style='margin:0 10px;';
    }
    if(flag==0){
        calligraphy.style='margin:-650px 10px 0;';
    }
}

//1开
function setSwiper(index){
   switch(index)
   {
       case 0:
            page1anmit(1);
            
            break;
       case 1:
            page1anmit(0);
            
            break;
       case 2:
            page1anmit(0);
            ;
            break;
   }
}
page1anmit(1);