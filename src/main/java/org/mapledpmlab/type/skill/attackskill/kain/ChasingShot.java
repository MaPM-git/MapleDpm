package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChasingShot extends AttackSkill {
    public ChasingShot() {
        this.setName("체이싱 샷");
        this.setDamage(676.0);
        this.setAttackCount(6L);
        this.setDelayByAttackSpeed(960L);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
        this.getMultiAttackInfo().add(420L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
