<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 부트스트랩 css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<!-- 폰트어썸 -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/partyMain.css" />
<title>파티메인페이지 - 메인</title>
</head>
<body>

	<%--HEADER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/header.jsp" />

	<main>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="/party/partyMain">메인</a></li>
			<li class="nav-item"><a class="nav-link"
				href="/party/leaderpage">파티관리</a></li>
			<li class="nav-item"><a class="nav-link" href="#">파티원</a></li>
			<li class="nav-item"><a class="nav-link" href="#">자유게시판</a></li>
			<li class="nav-item"><a class="nav-link" href="#">포토갤러리</a></li>
			<li class="nav-item"><a class="nav-link" href="#">채팅</a></li>
		</ul>
		<div class="container">
			<div class="container-party">
				<div class="partyImage">
					<img alt="파티메인이미지" class="img-fluid"
						src="https://github.com/EUN-Ng/bitcamp/blob/master/img/1.jpg?raw=true">
				</div>

				<div class="partyInfo">
					<div class="partyInfo-content">
						<div class="partyInfo-content-title">
							<h5>김진건의 돌아온 솔로 파티</h5>
							<p>파티창설일자:&nbsp;2021.11.23</p>
							<p>파티인원 수:&nbsp;20명</p>
							<p>새로운 사랑을 찾아 산기슭을 찾아 헤매는 진건이형처럼</p>
							<p>우리는 새로운 사람을 만나는 파티입니다.</p>
						</div>
					</div>
				</div>
			</div>
			<div class="partyCalendar">
				<div class="demos__main">
					<div class="demos__main-container" id="demo-content">
						<div
							class="demo-calendar fc fc-media-screen fc-direction-ltr fc-theme-standard">
							<div class="fc-header-toolbar fc-toolbar fc-toolbar-ltr">
								<div class="fc-toolbar-chunk">
									<div class="fc-button-group">
										<button type="button" title="Previous month"
											aria-pressed="false"
											class="fc-prev-button fc-button fc-button-primary">
											<span class="fc-icon fc-icon-chevron-left"></span>
										</button>
										<button type="button" title="Next month" aria-pressed="false"
											class="fc-next-button fc-button fc-button-primary">
											<span class="fc-icon fc-icon-chevron-right"></span>
										</button>
									</div>
									<button type="button" title="This month" disabled=""
										aria-pressed="false"
										class="fc-today-button fc-button fc-button-primary">today</button>
								</div>
								<div class="fc-toolbar-chunk">
									<h2 class="fc-toolbar-title" id="fc-dom-86">November 2021</h2>
								</div>
								<div class="fc-toolbar-chunk">
									<div class="fc-button-group">
										<button type="button" title="month view" aria-pressed="true"
											class="fc-dayGridMonth-button fc-button fc-button-primary fc-button-active">month</button>
										<button type="button" title="week view" aria-pressed="false"
											class="fc-timeGridWeek-button fc-button fc-button-primary">week</button>
										<button type="button" title="day view" aria-pressed="false"
											class="fc-timeGridDay-button fc-button fc-button-primary">day</button>
										<button type="button" title="list view" aria-pressed="false"
											class="fc-listWeek-button fc-button fc-button-primary">list</button>
									</div>
								</div>
							</div>
							<div aria-labelledby="fc-dom-86"
								class="fc-view-harness fc-view-harness-active"
								style="height: 754.074px;">
								<div class="fc-daygrid fc-dayGridMonth-view fc-view">
									<table role="grid" class="fc-scrollgrid  fc-scrollgrid-liquid">
										<thead role="rowgroup">
											<tr role="presentation"
												class="fc-scrollgrid-section fc-scrollgrid-section-header ">
												<th role="presentation"><div
														class="fc-scroller-harness">
														<div class="fc-scroller" style="overflow: hidden;">
															<table role="presentation" class="fc-col-header "
																style="width: 1016px;">
																<colgroup></colgroup>
																<thead role="presentation">
																	<tr role="row">
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-sun"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Sunday"
																					class="fc-col-header-cell-cushion ">Sun</a>
																			</div></th>
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-mon"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Monday"
																					class="fc-col-header-cell-cushion ">Mon</a>
																			</div></th>
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-tue"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Tuesday"
																					class="fc-col-header-cell-cushion ">Tue</a>
																			</div></th>
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-wed"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Wednesday"
																					class="fc-col-header-cell-cushion ">Wed</a>
																			</div></th>
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-thu"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Thursday"
																					class="fc-col-header-cell-cushion ">Thu</a>
																			</div></th>
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-fri"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Friday"
																					class="fc-col-header-cell-cushion ">Fri</a>
																			</div></th>
																		<th role="columnheader"
																			class="fc-col-header-cell fc-day fc-day-sat"><div
																				class="fc-scrollgrid-sync-inner">
																				<a aria-label="Saturday"
																					class="fc-col-header-cell-cushion ">Sat</a>
																			</div></th>
																	</tr>
																</thead>
															</table>
														</div>
													</div></th>
											</tr>
										</thead>
										<tbody role="rowgroup">
											<tr role="presentation"
												class="fc-scrollgrid-section fc-scrollgrid-section-body  fc-scrollgrid-section-liquid">
												<td role="presentation"><div
														class="fc-scroller-harness fc-scroller-harness-liquid">
														<div class="fc-scroller fc-scroller-liquid-absolute"
															style="overflow: hidden auto;">
															<div class="fc-daygrid-body fc-daygrid-body-balanced "
																style="width: 1016px;">
																<table role="presentation"
																	class="fc-scrollgrid-sync-table"
																	style="width: 1016px; height: 728px;">
																	<colgroup></colgroup>
																	<tbody role="presentation">
																		<tr role="row">
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sun fc-day-past fc-day-other"
																				data-date="2021-10-31" aria-labelledby="fc-dom-87"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-87" class="fc-daygrid-day-number"
																							title="Go to October 31, 2021" data-navlink=""
																							tabindex="0">31</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																				data-date="2021-11-01" aria-labelledby="fc-dom-89"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-89" class="fc-daygrid-day-number"
																							title="Go to November 1, 2021" data-navlink=""
																							tabindex="0">1</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-block-event fc-h-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-past"><div
																									class="fc-event-main">
																									<div class="fc-event-main-frame">
																										<div class="fc-event-title-container">
																											<div class="fc-event-title fc-sticky">All
																												Day Event</div>
																										</div>
																									</div>
																								</div>
																								<div
																									class="fc-event-resizer fc-event-resizer-end"></div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																				data-date="2021-11-02" aria-labelledby="fc-dom-91"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-91" class="fc-daygrid-day-number"
																							title="Go to November 2, 2021" data-navlink=""
																							tabindex="0">2</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																				data-date="2021-11-03" aria-labelledby="fc-dom-93"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-93" class="fc-daygrid-day-number"
																							title="Go to November 3, 2021" data-navlink=""
																							tabindex="0">3</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																				data-date="2021-11-04" aria-labelledby="fc-dom-95"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-95" class="fc-daygrid-day-number"
																							title="Go to November 4, 2021" data-navlink=""
																							tabindex="0">4</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																				data-date="2021-11-05" aria-labelledby="fc-dom-97"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-97" class="fc-daygrid-day-number"
																							title="Go to November 5, 2021" data-navlink=""
																							tabindex="0">5</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																				data-date="2021-11-06" aria-labelledby="fc-dom-99"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-99" class="fc-daygrid-day-number"
																							title="Go to November 6, 2021" data-navlink=""
																							tabindex="0">6</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																		</tr>
																		<tr role="row">
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																				data-date="2021-11-07" aria-labelledby="fc-dom-101"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-101" class="fc-daygrid-day-number"
																							title="Go to November 7, 2021" data-navlink=""
																							tabindex="0">7</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div
																							class="fc-daygrid-event-harness fc-daygrid-event-harness-abs"
																							style="top: 0px; left: 0px; right: -290.271px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-block-event fc-h-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-past"><div
																									class="fc-event-main">
																									<div class="fc-event-main-frame">
																										<div class="fc-event-title-container">
																											<div class="fc-event-title fc-sticky">Long
																												Event</div>
																										</div>
																									</div>
																								</div>
																								<div
																									class="fc-event-resizer fc-event-resizer-end"></div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 20px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																				data-date="2021-11-08" aria-labelledby="fc-dom-103"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-103" class="fc-daygrid-day-number"
																							title="Go to November 8, 2021" data-navlink=""
																							tabindex="0">8</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 20px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																				data-date="2021-11-09" aria-labelledby="fc-dom-105"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-105" class="fc-daygrid-day-number"
																							title="Go to November 9, 2021" data-navlink=""
																							tabindex="0">9</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 20px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-past"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">4p</div>
																								<div class="fc-event-title">Repeating
																									Event</div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																				data-date="2021-11-10" aria-labelledby="fc-dom-107"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-107" class="fc-daygrid-day-number"
																							title="Go to November 10, 2021" data-navlink=""
																							tabindex="0">10</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																				data-date="2021-11-11" aria-labelledby="fc-dom-109"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-109" class="fc-daygrid-day-number"
																							title="Go to November 11, 2021" data-navlink=""
																							tabindex="0">11</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																				data-date="2021-11-12" aria-labelledby="fc-dom-111"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-111" class="fc-daygrid-day-number"
																							title="Go to November 12, 2021" data-navlink=""
																							tabindex="0">12</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																				data-date="2021-11-13" aria-labelledby="fc-dom-113"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-113" class="fc-daygrid-day-number"
																							title="Go to November 13, 2021" data-navlink=""
																							tabindex="0">13</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																		</tr>
																		<tr role="row">
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																				data-date="2021-11-14" aria-labelledby="fc-dom-115"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-115" class="fc-daygrid-day-number"
																							title="Go to November 14, 2021" data-navlink=""
																							tabindex="0">14</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																				data-date="2021-11-15" aria-labelledby="fc-dom-117"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-117" class="fc-daygrid-day-number"
																							title="Go to November 15, 2021" data-navlink=""
																							tabindex="0">15</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-tue fc-day-past"
																				data-date="2021-11-16" aria-labelledby="fc-dom-119"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-119" class="fc-daygrid-day-number"
																							title="Go to November 16, 2021" data-navlink=""
																							tabindex="0">16</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-past"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">4p</div>
																								<div class="fc-event-title">Repeating
																									Event</div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-wed fc-day-past"
																				data-date="2021-11-17" aria-labelledby="fc-dom-121"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-121" class="fc-daygrid-day-number"
																							title="Go to November 17, 2021" data-navlink=""
																							tabindex="0">17</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-thu fc-day-past"
																				data-date="2021-11-18" aria-labelledby="fc-dom-123"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-123" class="fc-daygrid-day-number"
																							title="Go to November 18, 2021" data-navlink=""
																							tabindex="0">18</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-fri fc-day-past"
																				data-date="2021-11-19" aria-labelledby="fc-dom-125"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-125" class="fc-daygrid-day-number"
																							title="Go to November 19, 2021" data-navlink=""
																							tabindex="0">19</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sat fc-day-past"
																				data-date="2021-11-20" aria-labelledby="fc-dom-127"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-127" class="fc-daygrid-day-number"
																							title="Go to November 20, 2021" data-navlink=""
																							tabindex="0">20</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																		</tr>
																		<tr role="row">
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sun fc-day-past"
																				data-date="2021-11-21" aria-labelledby="fc-dom-129"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-129" class="fc-daygrid-day-number"
																							title="Go to November 21, 2021" data-navlink=""
																							tabindex="0">21</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-mon fc-day-past"
																				data-date="2021-11-22" aria-labelledby="fc-dom-131"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-131" class="fc-daygrid-day-number"
																							title="Go to November 22, 2021" data-navlink=""
																							tabindex="0">22</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div
																							class="fc-daygrid-event-harness fc-daygrid-event-harness-abs"
																							style="top: 0px; left: 0px; right: -145.135px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-block-event fc-h-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end"><div
																									class="fc-event-main">
																									<div class="fc-event-main-frame">
																										<div class="fc-event-title-container">
																											<div class="fc-event-title fc-sticky">Conference</div>
																										</div>
																									</div>
																								</div>
																								<div
																									class="fc-event-resizer fc-event-resizer-end"></div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 20px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-tue fc-day-today "
																				data-date="2021-11-23" aria-labelledby="fc-dom-133"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-133" class="fc-daygrid-day-number"
																							title="Go to November 23, 2021" data-navlink=""
																							tabindex="0">23</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 20px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-today"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">10:30a</div>
																								<div class="fc-event-title">Meeting</div></a>
																						</div>
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-today"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">12p</div>
																								<div class="fc-event-title">Lunch</div></a>
																						</div>
																						<div
																							class="fc-daygrid-event-harness fc-daygrid-event-harness-abs"
																							style="visibility: hidden; top: 0px; left: 0px; right: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-today"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">2:30p</div>
																								<div class="fc-event-title">Meeting</div></a>
																						</div>
																						<div
																							class="fc-daygrid-event-harness fc-daygrid-event-harness-abs"
																							style="visibility: hidden; top: 0px; left: 0px; right: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-today"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">5:30p</div>
																								<div class="fc-event-title">Happy Hour</div></a>
																						</div>
																						<div
																							class="fc-daygrid-event-harness fc-daygrid-event-harness-abs"
																							style="visibility: hidden; top: 0px; left: 0px; right: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-today"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">8p</div>
																								<div class="fc-event-title">Dinner</div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;">
																							<a class="fc-daygrid-more-link fc-more-link"
																								title="Show 3 more events" aria-expanded="false"
																								aria-controls="" tabindex="0">+3 more</a>
																						</div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-wed fc-day-future"
																				data-date="2021-11-24" aria-labelledby="fc-dom-135"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-135" class="fc-daygrid-day-number"
																							title="Go to November 24, 2021" data-navlink=""
																							tabindex="0">24</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-dot-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-future"><div
																									class="fc-daygrid-event-dot"></div>
																								<div class="fc-event-time">7a</div>
																								<div class="fc-event-title">Birthday Party</div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-thu fc-day-future"
																				data-date="2021-11-25" aria-labelledby="fc-dom-137"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-137" class="fc-daygrid-day-number"
																							title="Go to November 25, 2021" data-navlink=""
																							tabindex="0">25</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-fri fc-day-future"
																				data-date="2021-11-26" aria-labelledby="fc-dom-139"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-139" class="fc-daygrid-day-number"
																							title="Go to November 26, 2021" data-navlink=""
																							tabindex="0">26</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sat fc-day-future"
																				data-date="2021-11-27" aria-labelledby="fc-dom-141"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-141" class="fc-daygrid-day-number"
																							title="Go to November 27, 2021" data-navlink=""
																							tabindex="0">27</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																		</tr>
																		<tr role="row">
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sun fc-day-future"
																				data-date="2021-11-28" aria-labelledby="fc-dom-143"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-143" class="fc-daygrid-day-number"
																							title="Go to November 28, 2021" data-navlink=""
																							tabindex="0">28</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-event-harness"
																							style="margin-top: 0px;">
																							<a
																								class="fc-daygrid-event fc-daygrid-block-event fc-h-event fc-event fc-event-draggable fc-event-resizable fc-event-start fc-event-end fc-event-future"
																								href="http://google.com/"><div
																									class="fc-event-main">
																									<div class="fc-event-main-frame">
																										<div class="fc-event-title-container">
																											<div class="fc-event-title fc-sticky">Click
																												for Google</div>
																										</div>
																									</div>
																								</div>
																								<div
																									class="fc-event-resizer fc-event-resizer-end"></div></a>
																						</div>
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-mon fc-day-future"
																				data-date="2021-11-29" aria-labelledby="fc-dom-145"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-145" class="fc-daygrid-day-number"
																							title="Go to November 29, 2021" data-navlink=""
																							tabindex="0">29</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-tue fc-day-future"
																				data-date="2021-11-30" aria-labelledby="fc-dom-147"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-147" class="fc-daygrid-day-number"
																							title="Go to November 30, 2021" data-navlink=""
																							tabindex="0">30</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-wed fc-day-future fc-day-other"
																				data-date="2021-12-01" aria-labelledby="fc-dom-149"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-149" class="fc-daygrid-day-number"
																							title="Go to December 1, 2021" data-navlink=""
																							tabindex="0">1</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-thu fc-day-future fc-day-other"
																				data-date="2021-12-02" aria-labelledby="fc-dom-151"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-151" class="fc-daygrid-day-number"
																							title="Go to December 2, 2021" data-navlink=""
																							tabindex="0">2</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-fri fc-day-future fc-day-other"
																				data-date="2021-12-03" aria-labelledby="fc-dom-153"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-153" class="fc-daygrid-day-number"
																							title="Go to December 3, 2021" data-navlink=""
																							tabindex="0">3</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sat fc-day-future fc-day-other"
																				data-date="2021-12-04" aria-labelledby="fc-dom-155"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-155" class="fc-daygrid-day-number"
																							title="Go to December 4, 2021" data-navlink=""
																							tabindex="0">4</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																		</tr>
																		<tr role="row">
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sun fc-day-future fc-day-other"
																				data-date="2021-12-05" aria-labelledby="fc-dom-157"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-157" class="fc-daygrid-day-number"
																							title="Go to December 5, 2021" data-navlink=""
																							tabindex="0">5</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-mon fc-day-future fc-day-other"
																				data-date="2021-12-06" aria-labelledby="fc-dom-159"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-159" class="fc-daygrid-day-number"
																							title="Go to December 6, 2021" data-navlink=""
																							tabindex="0">6</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-tue fc-day-future fc-day-other"
																				data-date="2021-12-07" aria-labelledby="fc-dom-161"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-161" class="fc-daygrid-day-number"
																							title="Go to December 7, 2021" data-navlink=""
																							tabindex="0">7</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-wed fc-day-future fc-day-other"
																				data-date="2021-12-08" aria-labelledby="fc-dom-163"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-163" class="fc-daygrid-day-number"
																							title="Go to December 8, 2021" data-navlink=""
																							tabindex="0">8</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-thu fc-day-future fc-day-other"
																				data-date="2021-12-09" aria-labelledby="fc-dom-165"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-165" class="fc-daygrid-day-number"
																							title="Go to December 9, 2021" data-navlink=""
																							tabindex="0">9</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-fri fc-day-future fc-day-other"
																				data-date="2021-12-10" aria-labelledby="fc-dom-167"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-167" class="fc-daygrid-day-number"
																							title="Go to December 10, 2021" data-navlink=""
																							tabindex="0">10</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																			<td role="gridcell"
																				class="fc-daygrid-day fc-day fc-day-sat fc-day-future fc-day-other"
																				data-date="2021-12-11" aria-labelledby="fc-dom-169"><div
																					class="fc-daygrid-day-frame fc-scrollgrid-sync-inner">
																					<div class="fc-daygrid-day-top">
																						<a id="fc-dom-169" class="fc-daygrid-day-number"
																							title="Go to December 11, 2021" data-navlink=""
																							tabindex="0">11</a>
																					</div>
																					<div class="fc-daygrid-day-events">
																						<div class="fc-daygrid-day-bottom"
																							style="margin-top: 0px;"></div>
																					</div>
																					<div class="fc-daygrid-day-bg"></div>
																				</div></td>
																		</tr>
																	</tbody>
																</table>
															</div>
														</div>
													</div></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%--FOOTER--%>
	<jsp:include
		page="${pageContext.request.contextPath}/WEB-INF/views/include/footer.jsp" />

	<!-- 부트스트랩 js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<!-- 제이쿼리 -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<!-- 스윗알러트 -->
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/partyMain.js"></script>
</body>
</html>