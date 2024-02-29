package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DracoSlasher extends AttackSkill {
    public DracoSlasher() {
        this.setName("드라코 슬래셔");
        this.setDamage(740.0);
        this.setAttackCount(10L + 1);   // 기가 슬래셔-보너스 어택
        this.setDelayByAttackSpeed(720L);
        this.setAddDamage(20L);         // 기가 슬래셔-리인포스
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(50L);
        this.setCooldown(5.0);
        this.setRelatedSkill(new DracoSlasherEnergy());
    }
}
