var events = {
    events: {},
    subscribe: function (eventname, fn) {
        this.events[eventname] = this.events[eventname] || [];
        this.events[eventname].push(fn)
    },
    unsubscribe: function (eventname, fn) {
        if (this.events[eventname]) {
            for (var i = 0; i < this.events[eventname].length; i++) {
                if(this.events[eventname][i] === fn){
                    this.events[eventname].splice(i,1);
                }
            }
        }
    },
    publish: function (eventname, data) {
        this.events[eventname].forEach(function (fn) {
            fn(data);
        })
    }
}