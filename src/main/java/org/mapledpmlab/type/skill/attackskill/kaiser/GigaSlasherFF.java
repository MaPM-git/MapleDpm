package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GigaSlasherFF extends AttackSkill {
    public GigaSlasherFF() {
        this.setName("기가 슬래셔(파이널 피규레이션)");
        this.setDamage(580.0 + 75);
        this.setAttackCount(9L + 1 + 2);    // 기가 슬래셔-보너스 어택
        this.setDelay(570L);
        //this.setDelayByAttackSpeed(720L);
        this.setAddDamage(20L);     // 기가 슬래셔-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
