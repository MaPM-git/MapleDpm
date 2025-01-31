package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RemainIncense extends AttackSkill {
    public RemainIncense() {
        this.setName("리메인 인센스");
        this.setDamage(420.0);
        this.setAttackCount(4L);
        this.setCooldown(0.3);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(50L);
    }

    public void setAttackCountByCnt(int remainIncenseCnt) {
        this.setAttackCount(4L * remainIncenseCnt);
    }
}
