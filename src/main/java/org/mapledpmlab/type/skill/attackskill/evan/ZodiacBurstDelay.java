package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZodiacBurstDelay extends AttackSkill {
    public ZodiacBurstDelay() {
        this.setName("조디악 버스트");
        this.setDelay(3180L);
        this.setRelatedSkill(new ZodiacBurstMeteor());
    }
}
