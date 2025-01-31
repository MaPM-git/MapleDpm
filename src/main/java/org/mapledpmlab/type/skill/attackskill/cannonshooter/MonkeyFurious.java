package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MonkeyFurious extends AttackSkill {
    public MonkeyFurious() {
        this.setName("몽키 퓨리어스");
        this.setDamage(314.0);
        this.setAttackCount(9L);        // 벅샷
        this.setDelayByAttackSpeed(810L);
        this.setCooldown(60.0);
        this.addFinalDamage(0.45);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new MonkeyFuriousDot());
    }
}
