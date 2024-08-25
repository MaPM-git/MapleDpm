package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DracoSlasherFF extends AttackSkill {
    public DracoSlasherFF() {
        this.setName("드라코 슬래셔(파이널 피규레이션)");
        this.setDamage(740.0);
        this.setAttackCount(10L + 1 + 2);   // 기가 슬래셔-보너스 어택
        this.setDelay(570L);
        //this.setDelayByAttackSpeed(720L);
        this.setAddDamage(20L);         // 기가 슬래셔-리인포스
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(50L);
        this.setCooldown(5.0);
        this.setRelatedSkill(new DracoSlasherEnergyFF());
    }
}
