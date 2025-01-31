package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.MonkeyFuriousBuff;

public class MonkeyFuriousDot extends DotAttackSkill {
    public MonkeyFuriousDot() {
        this.setName("몽키 퓨리어스(도트)");
        this.setDamage(336.0);
        this.setAttackCount(1L);
        this.setDotDuration(60000L);
        this.setInterval(1000L);
        this.setRelatedSkill(new MonkeyFuriousBuff());
    }
}
