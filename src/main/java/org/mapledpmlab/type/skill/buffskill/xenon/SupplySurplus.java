package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SupplySurplus extends BuffSkill {
    public SupplySurplus() {
        this.setName("서플러스 서플라이");      // 에너지 자동충전 측정용
        this.setCooldown(4.0);
    }
}
