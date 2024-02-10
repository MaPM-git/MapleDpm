package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MagneticAnchorFinish extends AttackSkill {
    public MagneticAnchorFinish() {
        this.setName("마그네틱 앵커(막타)");
        this.setDamage(1100.0);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDelay(900L);
        this.setRelatedSkill(new MagneticAnchor());
        this.setCooldown(65.0);
    }
}
