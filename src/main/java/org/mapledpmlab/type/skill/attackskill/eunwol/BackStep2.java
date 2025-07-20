package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BackStep2 extends AttackSkill {
    public BackStep2() {
        this.setName("후방 이동(3회당 1번 캔슬)");
        this.setCooldown(1.2);
        this.setDelay(240L);
    }
}
