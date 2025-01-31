package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DracoSlasherEnergyFF extends AttackSkill {
    public DracoSlasherEnergyFF() {
        this.setName("드라코 슬래셔(용의 기운, 파이널 피규레이션)");
        this.setDamage(740.0 + 110);
        this.setAttackCount(6L + 1 + 2);    // 기가 슬래셔-보너스 어택
        this.setAddDamage(20L);         // 기가 슬래셔-리인포스
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(50L);
    }
}
