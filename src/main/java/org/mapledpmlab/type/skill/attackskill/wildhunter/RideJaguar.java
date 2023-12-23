package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RideJaguar extends AttackSkill {
    public RideJaguar() {
        this.setName("재규어 탑승");
        this.setDelay(1260L);
        this.setRelatedSkill(new SummonJaguar());
    }
}
