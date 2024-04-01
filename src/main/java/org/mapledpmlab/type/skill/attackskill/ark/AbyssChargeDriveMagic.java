package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbyssChargeDriveMagic extends AttackSkill implements LefSkill {
    public AbyssChargeDriveMagic() {
        this.setName("어비스 차지드라이브(심연의 마력)");
        this.setDamage(660.0);
        this.setAttackCount(6L);
        this.setCooldown(9.0);
        this.setRelatedSkill(new AbyssChargeDrive());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(720L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
