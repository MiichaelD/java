/* 
    Given the EventBus class and Listener interface:

    public final class EventBus {
    public void register(String eventName, Listener listener) {
        // TODO        
    }

    public void synchronized unregister(String eventName, Listener listener) {
        // TODO
    }

    public void synchronized postEvent(String eventName, Object data) {
        //TODO        
    }

    public interface Listener {
        void onEvent(Object data);
    }
}

    - Implement a system where Listeners register themselves to an event
      so everytime that event is posted the listener receives a callback.
    - Implement it as a Singleton.
    - Multithread-safe.
    
    - HackerRank sheet: http://hr.gs/b06f72
*/

// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.

import java.util.*;

public final class EventBus {

    private static EventBus eventBus;
    HashMap<String, HashSet<Listener>> m_listeners;
    
    private EventBus(){
        m_listeners = new HashMap<String, HashSet<Listener>>();
    }
    
    public static EventBus shared(){
        if (eventBus == null)
            eventBus = new EventBus();
        return eventBus;
    }

    public synchronized void register(String eventName, Listener listener) {
        HashSet<Listener> set;
        if (m_listeners.containsKey(eventName)){
            set = m_listeners.get(eventName);
            if (set.contains(listener))
                return;
        } else {
            set = new HashSet<Listener>();
            m_listeners.put(eventName, set);
        }

        // if we reach this point, we are sure this isn't a repeated listener
        set.add(listener);        
    }

    public synchronized void unregister(String eventName, Listener listener) {
        HashSet<Listener> set = m_listeners.get(eventName);
        if (set == null || !set.contains(listener))
            return;

        // if we reach this point, we are sure we have that item, lets erase it.
        set.remove(listener);
        
        // if there are no more listeners for this event, delete the event.
        if (set.isEmpty())
            m_listeners.remove(eventName);
    }

    public synchronized void postEvent(String eventName, Object data) {
        if (!m_listeners.containsKey(eventName))
            return;    
        
        HashSet<Listener> set = m_listeners.get(eventName);
        
        for (Listener listener : set){
            listener.onEvent(data);
        }
        
    }

    public static interface Listener {
        void onEvent(Object data);
    }
}

 /* 
    Given EventBusTest class, implement testRegister() method, which tests
    EventBus's functionality (you cannot modify EventBus to perform this test).
 */
class EventBusTest {
    static int eventsReceived = 0;

    class EventIncrementer implements EventBus.Listener{
        public void onEvent(Object data){
            ++eventsReceived;
            System.out.println("\tEvent received with data: "+data.toString());
        }       
    }

    void testRegister() {
        eventsReceived  = 0;
        String event = "onTouch()";
        String data = "123abc";
        EventIncrementer listener1 = new EventIncrementer();
        EventIncrementer listener2 = new EventIncrementer();
        EventBus bus = EventBus.shared();

        //we register 2 events;
        bus.register(event, listener1);
        bus.register(event, listener2);
        bus.register(event, listener1);

        //we notify the listeners of that event
        bus.postEvent(event, data);

        //we check if everything worked out correctly
        assert( eventsReceived == 2);
    }
    
    public static void main(String[] args){
        EventBusTest test = new EventBusTest();
        System.out.println("Beginning Test...");
        test.testRegister();
        System.out.println("Test DONE");
    }
}