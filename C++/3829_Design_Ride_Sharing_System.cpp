class RideSharingSystem {
    class Rider {
        public:
        int id_;
        Rider* prev_;
        Rider* next_;

        Rider(int id, Rider* prev, Rider* next) {
            id_ = id;
            prev_ = prev;
            next_ = next;
        }
    };

    Rider* start_;
    Rider* end_;
    std::queue<int> drivers_;
    std::map<int, Rider*> riders_;

    void add_to_front(Rider* rider) {
            rider->prev_ = start_;
            rider->next_ = start_->next_;
            start_->next_->prev_ = rider;
            start_->next_ = rider;
    }

    Rider* remove_from_back() {
        if(start_->next_ == end_) {
                return nullptr;
        }
        Rider* sol = end_->prev_;
        sol->prev_->next_ = end_;
        end_->prev_ = sol->prev_;

        return sol;
    }
public:

    RideSharingSystem() {
        start_ = new Rider(-1, nullptr,nullptr);
        end_ = new Rider(-1, nullptr, nullptr);
        start_->next_ = end_;
        end_->prev_ = start_;
    }
    
    void addRider(int riderId) {
        Rider* rider = new Rider(riderId, nullptr, nullptr);
        add_to_front(rider);
        riders_[riderId] = rider;
    }
    
    void addDriver(int driverId) {
        drivers_.push(driverId);
    }
    
    vector<int> matchDriverWithRider() {
        
        if(drivers_.empty() || start_->next_ == end_) {
            return {-1,-1};
        }
        int driver = drivers_.front();
        drivers_.pop();
        Rider* rider = remove_from_back();
        riders_.erase(rider->id_);
        return {driver, rider->id_};
    }
    
    void cancelRider(int riderId) {
        if(riders_.contains(riderId)) {
            Rider* to_remove = riders_[riderId];
            riders_.erase(riderId);
            to_remove->prev_->next_ = to_remove->next_;
            to_remove->next_->prev_ = to_remove->prev_;
        }
        
    }
};

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem* obj = new RideSharingSystem();
 * obj->addRider(riderId);
 * obj->addDriver(driverId);
 * vector<int> param_3 = obj->matchDriverWithRider();
 * obj->cancelRider(riderId);
 */
