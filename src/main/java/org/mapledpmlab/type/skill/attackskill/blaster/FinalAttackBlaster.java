package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackBlaster extends AttackSkill {
    public FinalAttackBlaster() {
        this.setName("리볼빙 캐논 마스터리(블래스터)");
        this.setAttackCount(1L);
        this.setDamage(700.0);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setProp(100L);
        this.setAddDamage(30L);     // 아티팩트
    }
}
