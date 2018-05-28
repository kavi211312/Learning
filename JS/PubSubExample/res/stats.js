var stats={
    people:['vinay'],
    elem:document.getElementById('people'),
    render: function(){
        debugger;
        var input = document.createElement('input');
        input.setAttribute('type','text');
        var button = document.createElement('button');
        button.innerHTML = 'Add';
        //var addPeopleFn = this.addPeople;
       // button.setAttribute('onclick', 'addPeopleFn()');
       //button.setAttribute('onclick', 'this.addPeople()');
       var that = this;
       button.addEventListener('click',function(){
           debugger;
           that.addPeople();
       })
        function addPeopleFn(){
            debugger;
        }
        var peopleElem = document.createElement('div');
        peopleElem.setAttribute('class','peopleList');
        this.elem.appendChild(input);
        this.elem.appendChild(button);
        this.elem.appendChild(peopleElem);
    },
    addPeople: function(){
        debugger;
        var p1 = this.elem.querySelector('input').value;
        this.people.push( p1 );
        this.renderPeople();
        events.publish('peopleChanged',this.people)
    },
    renderPeople: function(){
        debugger;
        if(this.elem.querySelector('.peopleList').childElementCount>0){
            var childNodes = this.elem.querySelector('.peopleList').childNodes;
            var len = childNodes.length;
            for(var i= len-1;i >= 0 ;i--){
                this.elem.querySelector('.peopleList').removeChild(childNodes[i]);
            }
        }
        for(var i=0; i< this.people.length; i++){
            var elem = document.createElement('div');
            elem.innerHTML = this.people[i];
            this.elem.querySelector('.peopleList').appendChild(elem);
        }
    }
}
stats.render();