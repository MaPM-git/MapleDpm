package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Beyonder3 extends AttackSkill {
    public Beyonder3() {
        this.setName("비욘더(청룡)");
        this.setDamage(675.0 + 135);    // 부스트 엔드-헌터즈 타겟팅
        this.setAttackCount(5L);
        this.addIgnoreDefenseList(30L);
        this.setDelayByAttackSpeed(600L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new FinalBeyonderWhiteTiger());
    }
}
