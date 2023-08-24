package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagneticAnchor extends AttackSkill {
    public MagneticAnchor() {
        this.setName("마그네틱 앵커");
        this.setDamage(470.0);
        this.setAttackCount(1L);
        this.setInterval(3000L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
